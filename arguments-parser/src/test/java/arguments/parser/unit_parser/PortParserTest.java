package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PortParserTest {

    private final String ARGUMENT_NAME = "Port";

    @Test
    public void should_return_port_0() {
        String stringToBeParsed = "";
        PortParser portParser = new PortParser();

        Argument parsedArgument = portParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertEquals(0, parsedArgument.getValue());
    }

    @Test
    public void should_return_port_0_2() {
        String stringToBeParsed = "-d /usr/logs";
        PortParser portParser = new PortParser();

        Argument parsedArgument = portParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertEquals(0, parsedArgument.getValue());
    }

    @Test
    public void should_return_port_1000() {
        String stringToBeParsed = "-p 1000";
        PortParser portParser = new PortParser();

        Argument parsedArgument = portParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertEquals(1000, parsedArgument.getValue());
    }

    @Test
    public void should_return_logging_true() {
        String stringToBeParsed = "-l -p 8080 -d /usr/logs";
        PortParser portParser = new PortParser();

        Argument parsedArgument = portParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertEquals(8080, parsedArgument.getValue());
    }

    @Test
    public void should_return_logging_true2() {
        String stringToBeParsed = "-l -d /usr/logs -p 8080";
        PortParser portParser = new PortParser();

        Argument parsedArgument = portParser.parse(stringToBeParsed);

        assertEquals(ARGUMENT_NAME, parsedArgument.getName());
        assertEquals(8080, parsedArgument.getValue());
    }

}
