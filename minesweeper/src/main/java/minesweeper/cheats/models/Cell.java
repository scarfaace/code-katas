package minesweeper.cheats.models;

import lombok.Getter;
import minesweeper.cheats.MinesField;
import minesweeper.cheats.exceptions.InvalidCellCharacterException;

import java.util.List;

@Getter
public abstract class Cell {

    protected CellPosition cellPosition;
    protected MinesField minesField;

    public Cell(int x, int y, MinesField minesField) {
        this.minesField = minesField;
        this.cellPosition = CellPosition.builder()
                .x(x)
                .y(y)
                .build();
    }

    public abstract boolean isMine();

    public static Cell fromString(String character, int x, int y, MinesField minesField) {
        if(character.equals("*")) {
            return new Mine(x, y, minesField);
        } else if(character.equals(".")) {
            return new EmptyCell(x, y, minesField);
        } else {
            throw new InvalidCellCharacterException("Could not create a new Cell due to invalid cell character.");
        }
    }

    /**
     * Returns the neighbouring cells of the current cell.
     * @return neighbouring cells of the current cell.
     */
    public List<Cell> getNeighbourhood() {
        return minesField.getCellNeighbourhood(this);
    }

    /**
     * Find out the number of mines around the current cell.
     * @return number of mines around the current cell
     */
    public int getMinesCountAround() {
        return (int) getNeighbourhood().stream()
                .filter(Cell::isMine)
                .count();
    }

}
