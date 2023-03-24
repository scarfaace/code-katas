package minesweeper.cheats;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinesFieldCreatorTest {

    @Test
    public void GIVEN_txtFilePath_WHEN_fromTxtCalled_THEN_minesFieldWithCorrectDimensionsIsReturned() {
        MinesFieldCreator minesFieldCreator = new MinesFieldCreator();
        String txtFilePath = "src/test/resources/field1.txt";

        MinesField minesField = minesFieldCreator.fromTxt(txtFilePath);

        assertEquals(4, minesField.getFieldWidth());
        assertEquals(4, minesField.getFieldHeight());
    }

}
