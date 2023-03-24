package minesweeper.cheats.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CellPosition {
    protected int x;
    protected int y;
}