package org.example.resp;

import org.example.exceptions.RespSyntaxException;
import org.example.resp.datatypes.RespDataType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
  void shouldDeserializeArray() {
    String input = "*1\r\n$4\r\nping\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    RespDataType deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString.getValue()).isEqualTo("ping");
  }

  @Test
  void shouldDeserializeArray2() {
    String input = "*2\r\n$4\r\necho\r\n$11\r\nhello world\r\n";
    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

    RespDataType deserializedString = respSerializer.deserialize(inputBytes);

    assertThat(deserializedString.getValue()).isEqualTo("echo hello world");
  }

  /***************************************** Integer String ******************************************/
  @Nested
  class IntegerTest {
    @Test
    void shouldDeserializeMaxValue64bitInteger() {
      String input = ":9223372036854775807\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      RespDataType deserializedString = respSerializer.deserialize(inputBytes);

      assertThat((Long)deserializedString.getValue()).isEqualTo(9_223_372_036_854_775_807L);
    }

    @Test
    void shouldThrowWhenPassedUnparsableInteger() {
      String input = ":9223372036854775808\r\n";   // This long overflows by 1
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
        .isInstanceOf(RespSyntaxException.class);
    }
  }

  /***************************************** Error ******************************************/
  @Nested
  class ErrorTest {
    @Test
    void shouldDeserializeError() {
      String input = "-Error message\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      RespDataType deserializedString = respSerializer.deserialize(inputBytes);

      assertThat(deserializedString.getValue()).isEqualTo("Error message");
    }

    @Test
    void shouldThrowWhenErrorContainsMultipleCRChars() {
      String input = "-E\rrror\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
        .isInstanceOf(RespSyntaxException.class);
    }

    @Test
    void shouldThrowWhenSimpleStringContainsMultipleLFChars() {
      String input = "-E\nrror\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
        .isInstanceOf(RespSyntaxException.class);
    }
  }

  /***************************************** Simple String ******************************************/
  @Nested
  class SimpleStringTest {
    @Test
    void shouldDeserializeSimpleString() {
      String input = "+OK\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      RespDataType deserializedString = respSerializer.deserialize(inputBytes);

      assertThat(deserializedString.getValue()).isEqualTo("OK");
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
  }

  /***************************************** Bulk String ******************************************/
  @Nested
  class BulkStringTest {
    @Test
    void shouldDeserializeNull() {
      String input = "$-1\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      RespDataType deserializedString = respSerializer.deserialize(inputBytes);

      assertThat(deserializedString.getValue()).isNull();
    }

    @Test
    void shouldThrowWhenPayloadStringSizeMismatchesActualPayloadStringSize() {
      String input = "$5\r\na\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      assertThatThrownBy(() -> respSerializer.deserialize(inputBytes))
        .isInstanceOf(RespSyntaxException.class);
    }

    @Test
    void shouldReturnPayloadString() {
      String input = "$8\r\ntest\0\r\na\r\n";
      byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);

      RespDataType deserializedString = respSerializer.deserialize(inputBytes);

      assertThat(deserializedString.getValue()).isEqualTo("test\0\r\na");
    }
  }

//  @Test
//  void fixMyName() {
//    String input = "$0\r\n\r\n";
//    byte[] inputBytes = input.getBytes(StandardCharsets.US_ASCII);
//
//    RespDataType deserializedString = respSerializer.deserialize(inputBytes);
//
//    assertThat(deserializedString.getValue()).isEqualTo("");
//  }

}
