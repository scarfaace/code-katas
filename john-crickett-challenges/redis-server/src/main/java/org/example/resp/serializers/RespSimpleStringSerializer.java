package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;

import static org.example.resp.serializers.LeadingDataTypeCharacters.SIMPLE_STRING;

public class RespSimpleStringSerializer extends AbstractRespSerializer {

  public RespSimpleStringSerializer() {
    super(SIMPLE_STRING);
  }

  @Override
  public String deserialize(String inputString) {
    validate(inputString);

    String parsedBodyString = inputString.substring(1, inputString.length() - 2);
    return parsedBodyString;
  }

  private void validate(String inputString) {
    if (inputString.indexOf('\r') != inputString.length() - 2) {
      throw new RespSyntaxException("Wrong position of \\r");
    }
    if (inputString.indexOf('\n') != inputString.length() - 1) {
      throw new RespSyntaxException("Wrong position of \\n");
    }
  }

}
