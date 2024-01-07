package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.datatypes.RespDataType;
import org.example.resp.serializers.constants.DataTypeLeadingCharacters;
import org.example.resp.serializers.constants.DataTypeNames;

public class RespErrorSerializer extends AbstractRespSerializer {

  public RespErrorSerializer() {
    super(DataTypeNames.ERROR, DataTypeLeadingCharacters.ERROR);
  }

  @Override
  public RespDataType deserialize(String inputString) {
    validate(inputString);

    String parsedErrorBodyString = inputString.substring(1, inputString.length() - 2);
    return RespDataType.builder()
      .value(parsedErrorBodyString)
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
