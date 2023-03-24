package minesweeper.cheats;

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
    public void GIVEN_txtFilePath_WHEN_fromTxtCalled_THEN_minesFieldWithCorrectDimensionsIsReturned() {
        String txtFilePath = "src/test/resources/field1.txt";

        MinesField minesField = minesFieldCreator.fromTxt(txtFilePath);

        assertEquals(4, minesField.getFieldWidth());
        assertEquals(4, minesField.getFieldHeight());
    }

}