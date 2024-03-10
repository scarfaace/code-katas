package org.example;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class TennisGame {

  private Player player1;
  private Player player2;

  private ScoreBoard scoreBoard;

  public void play() {
    if (scoreBoard.isGameFinished()) {
      return;
    }

    final Player gameWinner = generateGameWinner();
    final Player gameLoser = gameWinner == player1 ? player2 : player1;

    scoreBoard.addPointToPlayer(gameWinner, gameLoser);
  }

  private Player generateGameWinner() {
    final Random rand = new Random();
    final int randomNumber = rand.nextInt(0, 1);

    final Player pointWinner = randomNumber == 0 ? player1 : player2;
    return pointWinner;
  }

}
