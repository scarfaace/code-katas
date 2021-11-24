package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectoryParserTest {

    @Test
    public void GIVEN_easyStringToBeParsed_WHEN_directoryParsed_THEN_parsedDirectoryHasCorrectValue() {
        String stringToBeParsed = "-d /usr/logs";
        DirectoryParser directoryParser = new DirectoryParser();

        Argument parsedArgument = directoryParser.parse(stringToBeParsed);

        assertEquals("Directory", parsedArgument.getName());
        assertEquals("/usr/logs", parsedArgument.getValue());
    }

    @Test
    public void GIVEN_complexStringToBeParsed_WHEN_directoryParsed_THEN_parsedDirectoryHasCorrectValue() {
        String stringToBeParsed = "-l -p 8080 -d /usr/logs";
        DirectoryParser directoryParser = new DirectoryParser();

        Argument parsedArgument = directoryParser.parse(stringToBeParsed);

        assertEquals("Directory", parsedArgument.getName());
        assertEquals("/usr/logs", parsedArgument.getValue());
    }

    @Test
    public void GIVEN_complexStringToBeParsed_WHEN_directoryParsed_THEN_parsedDirectoryHasCorrectValue2() {
        String stringToBeParsed = "-l -d /usr/logs -p 8080";
        DirectoryParser directoryParser = new DirectoryParser();

        Argument parsedArgument = directoryParser.parse(stringToBeParsed);

        assertEquals("Directory", parsedArgument.getName());
        assertEquals("/usr/logs", parsedArgument.getValue());
    }

}
