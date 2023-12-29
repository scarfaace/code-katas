package org.example.resp.serializers;

public abstract class AbstractRespSerializer implements RespDataTypeSerializer {

  private final char leadingDataTypeCharacter;

  protected AbstractRespSerializer(char leadingDataTypeCharacter) {
    this.leadingDataTypeCharacter = leadingDataTypeCharacter;
  }

  @Override
  public boolean shouldDeserialize(String inputString) {
    return inputString.charAt(0) == leadingDataTypeCharacter;
  }

}
