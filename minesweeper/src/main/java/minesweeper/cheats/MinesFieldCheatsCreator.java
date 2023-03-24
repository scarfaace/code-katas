package minesweeper.cheats;

import minesweeper.cheats.models.Cell;

import java.util.ArrayList;
import java.util.List;

public class MinesFieldCheatsCreator {

    public List<List<Integer>> create(MinesField minesField) {
        Cell[][] minesFieldArray = minesField.getMinesField();
        List<List<Integer>> minesCheatsArray = new ArrayList<>(minesField.getFieldHeight());

        for(int y = 0; y <= minesField.getFieldHeight(); y++) {
            List<Integer> hintsRow = new ArrayList<>(minesField.getFieldWidth());
            for(int x = 0; x <= minesField.getFieldWidth(); x++) {
                Cell currentCell = minesFieldArray[y][x];
                hintsRow.add(currentCell.getMinesCountAround());
            }
            minesCheatsArray.add(hintsRow);
        }
        return minesCheatsArray;
    }

}
