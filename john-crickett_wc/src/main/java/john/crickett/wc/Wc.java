package john.crickett.wc;

import john.crickett.wc.options.CharacterCounter;
import john.crickett.wc.options.DataCounter;

import java.util.List;

public class Wc {
  private DataCounter dataCounter;

  public void execute(List<String> input) {
    String option = input.get(1);
    String filePath = input.get(input.size()-1);

    setDataCounter(option);
    long dataCount = dataCounter.count(filePath);

    String output = dataCount + " " + filePath;
    System.out.println(output);
  }

  private void setDataCounter(String option) {
    if (option.equals("-c")) {
      dataCounter = new CharacterCounter();
    }
  }


}