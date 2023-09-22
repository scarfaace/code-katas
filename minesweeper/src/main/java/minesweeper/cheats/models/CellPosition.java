package minesweeper.cheats.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import minesweeper.cheats.MinesField;

import java.util.Objects;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class CellPosition {
    protected int x;
    protected int y;

    /**
     * Valid position is not out of the minefield dimensions.
     * @param minesField
     * @return
     */
    public boolean isValidPositionInMineField(MinesField minesField) {
        return x >= 0 && y >= 0 ||
                x < minesField.getFieldWidth() && y < minesField.getFieldHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPosition that = (CellPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}