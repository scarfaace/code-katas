package minesweeper.cheats.models;

import minesweeper.cheats.MinesField;

public class EmptyCell extends Cell {

    public EmptyCell(int x, int y, MinesField minesField) {
        super(x, y, minesField);
    }

    public boolean isMine() {
        return false;
    }

}
