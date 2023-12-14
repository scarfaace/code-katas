package john.crickett.wc.options;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterCounterTest {
  private CharacterCounter characterCounter;

  @BeforeEach
  void beforeEach() {
    characterCounter = new CharacterCounter();
  }

  @Test
  void count_lines_in_short_file() {
    String filePath = "src/test/resources/simple-test.txt";

    long characterCount = characterCounter.count(filePath);

    assertThat(characterCount).isEqualTo(117);
  }

  @Test
  void count_lines_in_short_crlf_file() {
    String filePath = "src/test/resources/simple-test-crlf.txt";

    long characterCount = characterCounter.count(filePath);

    assertThat(characterCount).isEqualTo(506);
  }

  @Test
  void count_lines_in_long_file() {
    String filePath = "src/test/resources/test.txt";

    long characterCount = characterCounter.count(filePath);

    assertThat(characterCount).isEqualTo(339292);
  }
}
