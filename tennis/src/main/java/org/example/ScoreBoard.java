package org.example;

import lombok.Getter;
import org.example.Score.ScoreValue;

import java.util.HashMap;
import java.util.Map;


public class ScoreBoard {

  private final Map<Player, Score> playerScores;

  private boolean isDeuce = false;
  private boolean isGameFinished = false;
  @Getter
  private Player winner = null;

  public ScoreBoard(Player player1, Player player2) {
    playerScores = new HashMap<>();

    playerScores.put(player1, new Score());
    playerScores.put(player2, new Score());
  }

  public boolean isGameFinished() {
    return isGameFinished;
  }

  public void addPointToPlayer(Player pointWinner, Player otherPlayer) {
    final Score pointWinnerScore = playerScores.get(pointWinner);
    final Score otherPlayerScore = playerScores.get(otherPlayer);

    // other player is in advantage, reduce their points
    if (isDeuce && otherPlayerScore.isAdvantage()) {
      otherPlayerScore.decreasePoint();
      return;
    }

    pointWinnerScore.addPoint();

    if (pointWinnerScore.isWin()) {
      isGameFinished = true;
      winner = pointWinner;
      return;
    }

    if (pointWinnerScore.is(ScoreValue._40) && otherPlayerScore.is(ScoreValue._40)) {
      pointWinnerScore.setDeuce();
      otherPlayerScore.setDeuce();
      isDeuce = true;
      return;
    }
  }

}
