package john.crickett.wc.options.datacounter;

import john.crickett.wc.options.datacounter.units.*;

import java.util.ArrayList;
import java.util.List;

public class DataCounterController {
  private List<DataCounter> dataCounters;

  public void executeDataCounters(String filePath) {
    dataCounters.forEach(dataCounter -> System.out.print(dataCounter.count(filePath) + "\t"));
    System.out.println(filePath);
  }

  public void initializeDataCounters(String option) {
    dataCounters = new ArrayList<>();

    if (option == null) {
      dataCounters.addAll(List.of(
        new LineCounter(),
        new WordCounter(),
        new ByteCounter()
      ));
    } else if (option.equals("-c")) {
      dataCounters.add(new ByteCounter());
    } else if (option.equals("-l")) {
      dataCounters.add(new LineCounter());
    } else if (option.equals("-w")) {
      dataCounters.add(new WordCounter());
    } else if (option.equals("-m")) {
      dataCounters.add(new CharacterCounter());
    }
  }


}
