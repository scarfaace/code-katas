package john.crickett.wc.options;

import org.apache.commons.io.FileUtils;

import java.io.File;


public class CharacterCounter implements DataCounter {
  @Override
  public long count(String filePath) {
    return FileUtils.sizeOf(new File(filePath));
  }
}
