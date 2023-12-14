package john.crickett.wc;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Wc wc = new Wc();
    wc.execute(Arrays.asList(args));

    System.out.println("Hello world!");
  }
}
