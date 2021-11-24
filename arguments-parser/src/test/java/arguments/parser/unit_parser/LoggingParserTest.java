package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggingParserTest {

    private final String ARGUMENT_NAME = "Logging";

    @Test
    public void should_return_logging_false() {
        String stringToBeParsed = "";
        LoggingParser loggingParser = new LoggingParser();

        Argument parsedArgument = loggingParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertFalse((Boolean) parsedArgument.getValue());
    }

    @Test
    public void should_return_logging_false2() {
        String stringToBeParsed = "-d /usr/logs";
        LoggingParser loggingParser = new LoggingParser();

        Argument parsedArgument = loggingParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertFalse((Boolean) parsedArgument.getValue());
    }

    @Test
    public void should_return_logging_true() {
        String stringToBeParsed = "-l -p 8080 -d /usr/logs";
        LoggingParser loggingParser = new LoggingParser();

        Argument parsedArgument = loggingParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertTrue((Boolean) parsedArgument.getValue());
    }

    @Test
    public void should_return_logging_true2() {
        String stringToBeParsed = "-l -d /usr/logs -p 8080";
        LoggingParser loggingParser = new LoggingParser();

        Argument parsedArgument = loggingParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertTrue((Boolean) parsedArgument.getValue());
    }

}
