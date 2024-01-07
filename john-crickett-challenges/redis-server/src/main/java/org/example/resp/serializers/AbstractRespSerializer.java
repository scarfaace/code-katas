package org.example.resp.serializers;

public abstract class AbstractRespSerializer implements RespDataTypeSerializer {

  protected final String dataTypeName;
  protected final char leadingDataTypeCharacter;

  protected AbstractRespSerializer(String dataTypeName, char leadingDataTypeCharacter) {
    this.dataTypeName = dataTypeName;
    this.leadingDataTypeCharacter = leadingDataTypeCharacter;
  }

  @Override
  public boolean shouldDeserialize(String inputString) {
    return inputString.charAt(0) == leadingDataTypeCharacter;
  }

}
