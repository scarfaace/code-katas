package org.example;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public class Player {

  @Getter
  private String name;

  private Score score = new Score();

  public static Player generateRandomPlayer() {
    final String name = UUID.randomUUID()
      .toString()
      .substring(0, 6);

    return Player.builder()
      .name(name)
      .build();
  }

}
