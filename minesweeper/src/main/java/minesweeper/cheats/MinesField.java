package minesweeper.cheats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minesweeper.cheats.models.Cell;
import minesweeper.cheats.models.CellPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MinesField {

    private Cell[][] minesField;
    private int fieldHeight;
    private int fieldWidth;

    public MinesField(Cell[][] minesField) {
        this.minesField = minesField;
        this.fieldHeight = minesField.length;
        this.fieldWidth = minesField[0].length;
    }

    /**
     * Returns the neighbourhood of the cell.
     * @param cell
     * @return
     */
    public List<Cell> getCellNeighbourhood(Cell cell) {
        List<CellPosition> neighbouringCellPositions = generateNeighbouringCellPositions(cell);
        return neighbouringCellPositions.stream()
                .map(cellPosition -> {
                    int posX = cellPosition.getX();
                    int posY = cellPosition.getY();
                    return minesField[posY][posX];
                })
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of positions of cell's neighbouring cells.
     * @param cell
     * @return
     */
    private List<CellPosition> generateNeighbouringCellPositions(Cell cell) {
        int cellYPosition = cell.getCellPosition().getY();
        int cellXPosition = cell.getCellPosition().getX();

        List<CellPosition> neighbouringCellPositions = new ArrayList<>();
        for(int y=cellYPosition-1; y < cellYPosition + 1; y++) {
            for(int x=cellXPosition-1; x < cellXPosition + 1; x++) {
                neighbouringCellPositions.add(new CellPosition(x, y));
            }
        }
        return neighbouringCellPositions;
    }

}
