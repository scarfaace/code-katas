package org.example.resp.serializers;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.datatypes.RespDataType;
import org.example.resp.serializers.constants.DataTypeNames;
import org.example.resp.serializers.constants.DataTypeLeadingCharacters;

public class RespIntegerSerializer extends AbstractRespSerializer {

  public RespIntegerSerializer() {
    super(DataTypeNames.INTEGER, DataTypeLeadingCharacters.INTEGER);
  }

  @Override
  public RespDataType deserialize(String inputString) {
    try {
      return RespDataType.builder()
        .value(Long.parseLong(inputString.substring(1, inputString.length() - 2)))
        .dataType(dataTypeName)
        .build();
    } catch (NumberFormatException e) {
      throw new RespSyntaxException("Invalid 64bit signed integer", e);
    }
  }

}
