package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Score {

  @Getter
  private boolean isDeuce = false;

  @Getter
  private ScoreValue value = ScoreValue.LOVE;

  public void addPoint() {
    if (value == ScoreValue.LOVE) {
      value = ScoreValue._15;
      return;
    }
    if (value == ScoreValue._15) {
      value = ScoreValue._30;
      return;
    }
    if (value == ScoreValue._30) {
      value = ScoreValue._40;
      return;
    }
    if (value == ScoreValue._40) {
      if (!isDeuce) {
        value = ScoreValue.WIN;
        return;
      }
      if (isDeuce) {
        value = ScoreValue.ADVANTAGE;
        return;
      }
    }

    if (value == ScoreValue.ADVANTAGE) {
      value = ScoreValue.WIN;
      return;
    }
  }

  public void decreasePoint() {
    if (value == ScoreValue.ADVANTAGE) {
      value = ScoreValue._40;
      return;
    }

    throw new IllegalStateException("Can't decrease points. Current score: '" + value + "'");
  }

  public boolean isWin() {
    return value == ScoreValue.WIN;
  }

  public boolean is(ScoreValue scoreValue) {
    return this.value == scoreValue;
  }

  public boolean isAdvantage() {
    return is(ScoreValue.ADVANTAGE);
  }

  public void setDeuce() {
    isDeuce = true;
  }

  public enum ScoreValue {
    LOVE, _15, _30, _40, ADVANTAGE, WIN
  }

}
