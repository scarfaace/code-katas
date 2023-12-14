package john.crickett.wc.options.datacounter.units;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;


public class LineCounter implements DataCounter {
  @SneakyThrows
  @Override
  public long count(String filePath) {
    return Files.lines(Path.of(filePath)).count();
  }
}
