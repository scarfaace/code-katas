package john.crickett.wc.options;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class CharacterCounter implements DataCounter {
  // TODO fix me!!! -> does not correctly work with \cr or \lf EOF. Only with \cr\lf
  @SneakyThrows
  @Override
  public long count(String filePath) {
    try (Stream<String> linesStream = Files.lines(Path.of(filePath))) {
      return linesStream
        .map(line -> line.length() + 2)   // +2 adds \cr\lf characters...; if only \cr or \lf indicates EOF, this computation is incorrect
        .reduce(Integer::sum).orElse(0);
    }
  }
}
