package minesweeper.cheats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinesFieldCheatsCreatorTest {
    private MinesFieldCheatsCreator minesFieldCheatsCreator;
    private MinesFieldCreator minesFieldCreator;

    @BeforeEach
    void beforeEach() {
        minesFieldCheatsCreator = new MinesFieldCheatsCreator();
        minesFieldCreator = new MinesFieldCreator();
    }

    @Test
    public void test() {
        MinesField minesField = minesFieldCreator.fromTxt("src/test/resources/field1.txt");

        List<List<Integer>> lists = minesFieldCheatsCreator.create(minesField);

        assertEquals(4, minesField.getFieldWidth());
        assertEquals(4, minesField.getFieldHeight());
    }

}
