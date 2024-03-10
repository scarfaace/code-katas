package org.example;

import static org.example.Player.generateRandomPlayer;

public class Main {

  public static void main(String[] args) {
    final Player player1 = generateRandomPlayer();
    final Player player2 = generateRandomPlayer();

    final ScoreBoard scoreBoard = new ScoreBoard(player1, player2);

    final TennisGame game = new TennisGame(player1, player2, scoreBoard);

    game.play();

    Announcer.announceWinner(scoreBoard);
  }

}
