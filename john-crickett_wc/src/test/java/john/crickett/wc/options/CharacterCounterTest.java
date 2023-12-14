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
  void counts_characters_in_short_file() {
    String filePath = "src/test/resources/simple-test.txt";

    long characterCount = characterCounter.count(filePath);

    assertThat(characterCount).isEqualTo(117);
  }

  @Test
  void counts_characters_in_long_file() {
    String filePath = "src/test/resources/test.txt";

    long characterCount = characterCounter.count(filePath);

    assertThat(characterCount).isEqualTo(342190);
  }
}
