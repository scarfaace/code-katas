package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.datatypes.RespDataType;
import org.example.resp.serializers.constants.DataTypeLeadingCharacters;
import org.example.resp.serializers.constants.DataTypeNames;

public class RespBulkStringSerializer extends AbstractRespSerializer {

  public RespBulkStringSerializer() {
    super(DataTypeNames.BULK_STRING, DataTypeLeadingCharacters.BULK_STRING);
  }

  @Override
  public RespDataType deserialize(String inputString) {
    if (isNull(inputString)) {
      return RespDataType.builder()
        .value(null)
        .dataType(dataTypeName)
        .build();
    }

    validate(inputString);
    return RespDataType.builder()
      .value(parsePayloadString(inputString))
      .dataType(dataTypeName)
      .build();
  }

  private boolean isNull(String inputString) {
    if (inputString.equals("$-1\r\n")) {
      return true;
    }
    return false;
  }

  private void validate(String inputString) {
    int payloadStringSize = parsePayloadStringSize(inputString);
    int charsCountBesidesStringBody = 5 + Integer.toString(payloadStringSize).length();
    int actualPayloadStringSize = inputString.length() - charsCountBesidesStringBody;

    if (inputString.length() > 512*1000*1000) {
      throw new RespSyntaxException("Bulk string exceeds size 512MB");
    }
    if (payloadStringSize != actualPayloadStringSize) {
      throw new RespSyntaxException("Prescribed body size does not match the actual body size");
    }
  }

  private int parsePayloadStringSize(String inputString) {
    int firstCRLFIndex = inputString.indexOf("\r\n");
    return Integer.parseInt(inputString.substring(1, firstCRLFIndex));
  }

  private String parsePayloadString(String inputString) {
    int payloadStringSize = parsePayloadStringSize(inputString);
    int startIndexOfPayloadString = 3 + Integer.toString(payloadStringSize).length();
    return inputString.substring(startIndexOfPayloadString, inputString.length() - 2);
  }

}
