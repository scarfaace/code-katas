package john.crickett.wc.options;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ByteCounterTest {
  private ByteCounter byteCounter;

  @BeforeEach
  void beforeEach() {
    byteCounter = new ByteCounter();
  }

  @Test
  void count_characters_in_short_file() {
    String filePath = "src/test/resources/simple-test.txt";

    long characterCount = byteCounter.count(filePath);

    assertThat(characterCount).isEqualTo(117);
  }

  @Test
  void count_characters_in_long_file() {
    String filePath = "src/test/resources/test.txt";

    long characterCount = byteCounter.count(filePath);

    assertThat(characterCount).isEqualTo(342190);
  }
}
