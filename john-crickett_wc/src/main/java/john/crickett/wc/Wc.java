package john.crickett.wc;

import john.crickett.wc.options.datacounter.DataCounterController;

import java.util.List;

public class Wc {
  private DataCounterController dataCounterController;

  public void execute(List<String> input) {
    dataCounterController = new DataCounterController();
    String filePath = input.get(input.size()-1);

    if (input.size() == 2) {
      dataCounterController.initializeDataCounters(null);
    } else if (input.size() == 3) {
      String dataCountOption = input.get(1);
      dataCounterController.initializeDataCounters(dataCountOption);
    } else {
      throw new IllegalArgumentException("Wrong command execution format.");
    }

    dataCounterController.executeDataCounters(filePath);
  }
}
