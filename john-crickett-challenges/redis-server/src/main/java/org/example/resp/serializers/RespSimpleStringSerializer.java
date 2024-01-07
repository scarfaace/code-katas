package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.datatypes.RespDataType;
import org.example.resp.serializers.constants.DataTypeNames;
import org.example.resp.serializers.constants.DataTypeLeadingCharacters;

public class RespSimpleStringSerializer extends AbstractRespSerializer {

  public RespSimpleStringSerializer() {
    super(DataTypeNames.SIMPLE_STRING, DataTypeLeadingCharacters.SIMPLE_STRING);
  }

  @Override
  public RespDataType deserialize(String inputString) {
    validate(inputString);

    String parsedBodyString = inputString.substring(1, inputString.length() - 2);
    return RespDataType.builder()
      .value(parsedBodyString)
      .dataType(dataTypeName)
      .build();
  }

  /**
   * Validates if \r and \n are positioned only at the very last two positions
   * of the RESP string. If either of these is positioned earlier in the string,
   * the string is invalid.
   * @param inputString
   */
  private void validate(String inputString) {
    if (inputString.indexOf('\r') != inputString.length() - 2) {
      throw new RespSyntaxException("Wrong position of \\r");
    }
    if (inputString.indexOf('\n') != inputString.length() - 1) {
      throw new RespSyntaxException("Wrong position of \\n");
    }
  }

}
