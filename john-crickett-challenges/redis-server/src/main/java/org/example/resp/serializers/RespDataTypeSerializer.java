package org.example.resp.serializers;

public interface RespDataTypeSerializer {

  /**
   * From bytes to higher-level representation. Said differently - decode RESP string.
   * @param inputString
   * @return
   */
  String deserialize(String inputString);

  /**
   * Answers whether this serializer should deserialize the string.
   * @param inputString
   * @return
   */
  boolean shouldDeserialize(String inputString);

}
