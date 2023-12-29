package org.example.resp;

import org.example.exceptions.RespSyntaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RespSerializerTest {

  private RespSerializer respSerializer;

  @BeforeEach
  void beforeEach() {
    respSerializer = new RespSerializer();
  }

  @Test
  void shouldDeserializeNull() {
    String input = "$-1\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    String deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString).isNull();
  }

  @Test
  void shouldDeserializeArray() {
    String input = "*1\r\n$4\r\nping\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    String deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString).isEqualTo("ping");
  }

  @Test
  void shouldDeserializeArray2() {
    String input = "*2\r\n$4\r\necho\r\n$11\r\nhello world\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    String deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString).isEqualTo("echo hello world");
  }

  @Test
  void shouldDeserializeSimpleString() {
    String input = "+OK\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    String deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString).isEqualTo("OK");
  }

  @Test
  void shouldThrowWhenSimpleStringContainsMultipleCRChars() {
    String input = "+O\rK\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
      .isInstanceOf(RespSyntaxException.class);
  }

  @Test
  void shouldThrowWhenSimpleStringContainsMultipleLFChars() {
    String input = "+O\nK\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
      .isInstanceOf(RespSyntaxException.class);
  }

  @Test
  void fixMyName() {
    String input = "$0\r\n\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    String deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString).isEqualTo("");
  }

}
