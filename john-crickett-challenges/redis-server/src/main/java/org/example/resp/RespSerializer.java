package org.example.resp;

import org.example.resp.serializers.RespDataTypeSerializer;
import org.example.resp.serializers.RespSimpleStringSerializer;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class RespSerializer {

  private final List<RespDataTypeSerializer> dataTypeSerializers;

  public RespSerializer() {
    dataTypeSerializers = List.of(
      new RespSimpleStringSerializer()
    );
  }

  /**
   * From bytes to higher-level representation. Said differently - decode RESP string.
   *
   * @param inputBytes
   * @return
   */
  public String deserialize(byte[] inputBytes) {
    String inputString = new String(inputBytes, StandardCharsets.US_ASCII);
    for (RespDataTypeSerializer dataTypeSerializer : dataTypeSerializers) {
      if (dataTypeSerializer.shouldDeserialize(inputString)) {
        return dataTypeSerializer.deserialize(inputString);
      }
    }

    throw new IllegalArgumentException("Invalid input string");
  }

  /**
   * Serialize (a.k.a. encode) higher-level string to RESP.
   *
   * @param outputString
   * @return
   */
  public byte[] serialize(String outputString) {
    throw new RuntimeException("Not implemented");
  }

}
