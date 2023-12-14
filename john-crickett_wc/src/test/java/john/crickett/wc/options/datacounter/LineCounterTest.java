package john.crickett.wc.options.datacounter;

import john.crickett.wc.options.datacounter.units.LineCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineCounterTest {
  private LineCounter lineCounter;

  @BeforeEach
  void beforeEach() {
    lineCounter = new LineCounter();
  }

  @Test
  void count_lines_in_short_file() {
    String filePath = "src/test/resources/simple-test.txt";

    long lineCount = lineCounter.count(filePath);

    assertThat(lineCount).isEqualTo(3);
  }

  @Test
  void count_lines_in_long_file() {
    String filePath = "src/test/resources/test.txt";

    long lineCount = lineCounter.count(filePath);

    assertThat(lineCount).isEqualTo(7145);
  }
}
