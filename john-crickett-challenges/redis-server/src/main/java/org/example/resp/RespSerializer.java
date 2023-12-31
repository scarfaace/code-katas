package org.example.resp;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.serializers.RespBulkStringSerializer;
import org.example.resp.serializers.RespDataTypeSerializer;
import org.example.resp.serializers.RespSimpleStringSerializer;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class RespSerializer {

  private final List<RespDataTypeSerializer> dataTypeSerializers;

  public RespSerializer() {
    dataTypeSerializers = List.of(
      new RespSimpleStringSerializer(),
      new RespBulkStringSerializer()
    );
  }

  /**
   * From bytes to higher-level representation. Said differently - decode RESP string.
   *
   * @param inputBytes
   * @return
   */
  public String deserialize(byte[] inputBytes) {
    validateBasicSyntax(inputBytes);

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

  /**
   * Validates the basic syntax rules:
   * <ul>
   *   <li>contains the leading character deciding the data type</li>
   *   <li>trailing <code>\r\n</code></li>
   * </ul>
   * @param inputBytes
   */
  private void validateBasicSyntax(byte[] inputBytes) {
    if (inputBytes.length < 3) {
      throw new RespSyntaxException("Too few characters");
    }
    if (inputBytes[inputBytes.length-2] != '\r' || inputBytes[inputBytes.length-1] != '\n') {
      throw new RespSyntaxException("RESP string not terminated with \"\\r\\n\"");
    }
  }

}
