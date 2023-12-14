package john.crickett.wc.options;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class WordCounter implements DataCounter {
  @SneakyThrows
  @Override
  public long count(String filePath) {
    try (Stream<String> linesStream = Files.lines(Path.of(filePath))) {
      return linesStream
        .map(String::trim)
        .map(line -> {
          if (line.isEmpty())
            return 0;
          return line.split("\\s+").length;
        })
        .reduce(Integer::sum).orElse(0);
    }
  }
}
