package org.example;

public class Announcer {

  public static void announceWinner(ScoreBoard scoreBoard) {
    final Player winner = scoreBoard.getWinner();

    System.out.println("The winner is '" + winner + "'");
  }

}
