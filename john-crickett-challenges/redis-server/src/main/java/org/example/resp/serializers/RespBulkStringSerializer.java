package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;

import static org.example.resp.serializers.LeadingDataTypeCharacters.BULK_STRING;

public class RespBulkStringSerializer extends AbstractRespSerializer {

  public RespBulkStringSerializer() {
    super(BULK_STRING);
  }

  @Override
  public String deserialize(String inputString) {
    if (isNull(inputString)) {
      return null;
    }

    validate(inputString);
    return parsePayloadString(inputString);
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
