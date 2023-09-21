package minesweeper.cheats;

import minesweeper.cheats.models.CellPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinesFieldCreatorTest {
    private MinesFieldCreator minesFieldCreator;

    @BeforeEach
    void beforeEach() {
        minesFieldCreator = new MinesFieldCreator();
    }

    @Test
    public void shouldCreateMinesFieldWithCorrectDimensionsFromTextFile() {
        String txtFilePath = "src/test/resources/field1.txt";

        MinesField minesField = minesFieldCreator.fromTxt(txtFilePath);

        assertEquals(4, minesField.getFieldWidth());
        assertEquals(4, minesField.getFieldHeight());
    }

    @Test
    public void shouldCreateCellsWithCorrectDimensions() {
        String txtFilePath = "src/test/resources/field1.txt";
        int fieldHeight = 4;
        int fieldWidth = 4;

        MinesField minesField = minesFieldCreator.fromTxt(txtFilePath);

        CellPosition cell1Position = minesField.getCell(0, 0).getCellPosition();
        assertEquals(0, cell1Position.getX());
        assertEquals(0, cell1Position.getY());
        CellPosition cell2Position = minesField.getCell(fieldHeight-1, fieldWidth-1).getCellPosition();
        assertEquals(3, cell2Position.getX());
        assertEquals(3, cell2Position.getY());
    }
}
