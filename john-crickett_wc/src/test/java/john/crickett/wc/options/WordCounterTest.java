package john.crickett.wc.options;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest {
  private WordCounter wordCounter;

  @BeforeEach
  void beforeEach() {
    wordCounter = new WordCounter();
  }

  @Test
  void count_lines_in_short_file() {
    String filePath = "src/test/resources/simple-test.txt";

    long wordCount = wordCounter.count(filePath);

    assertThat(wordCount).isEqualTo(23);
  }

  @Test
  void count_lines_in_long_file() {
    String filePath = "src/test/resources/test.txt";

    long wordCount = wordCounter.count(filePath);

    assertThat(wordCount).isEqualTo(58164);
  }
}
