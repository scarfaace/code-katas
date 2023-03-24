package minesweeper.cheats;

import lombok.Builder;
import lombok.Getter;
import minesweeper.cheats.models.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class MinesFieldCreator {

    public MinesField fromTxt(String txtFilePath) {
        FieldDimensions fieldDimensions = getFieldDimensions(txtFilePath);
        MinesField minesField = new MinesField();
        Cell[][] minesFieldArray = new Cell[fieldDimensions.getHeight()][fieldDimensions.getWidth()];

        try {
            int lineNumber = 0;
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] lineCharacters = myReader.nextLine().split("");
                int yCoordinate = lineNumber;
                Cell[] cellsLine = IntStream.range(0, fieldDimensions.getWidth())
                        .mapToObj(charIndex -> Cell.fromString(lineCharacters[charIndex], charIndex, yCoordinate, minesField))
                        .toArray(Cell[]::new);
                minesFieldArray[lineNumber] = cellsLine;
                lineNumber += 1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed reading field file.");
            e.printStackTrace();
        }

        minesField.setFieldHeight(fieldDimensions.getHeight());
        minesField.setFieldWidth(fieldDimensions.getWidth());
        minesField.setMinesField(minesFieldArray);
        return minesField;
    }

    private FieldDimensions getFieldDimensions(String txtFilePath) {
        int height = 0;
        int width = 0;
        Set<Integer> widths = new HashSet<Integer>();

        try {
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int lineWidth = line.length();
                if(!widths.contains(lineWidth) && !widths.isEmpty()) {
                    throw new RuntimeException("Line widths of field not always the sane.");
                }
                widths.add(lineWidth);
                width = lineWidth;
                height += 1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed reading field file.");
            e.printStackTrace();
        }
        if(height == 0) {
            throw new RuntimeException("Field is empty");
        }
        return FieldDimensions.builder()
                .height(height)
                .width(width)
                .build();
    }

    @Getter
    @Builder
    private static class FieldDimensions {
        private final int height;
        private final int width;
    }
}
