package minesweeper.cheats.models;

import minesweeper.cheats.MinesField;

public class Mine extends Cell {

    public Mine(int x, int y, MinesField minesField) {
        super(x, y, minesField);
    }

    public boolean isMine() {
        return true;
    }

}
