package arguments.parser;

import arguments.parser.arguments.Argument;
import arguments.parser.unit_parser.DirectoryParser;
import arguments.parser.unit_parser.LoggingParser;
import arguments.parser.unit_parser.PortParser;
import arguments.parser.unit_parser.UnitParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParserTest {

    @Test
    public void numberOfParsedArgumentsIsCorrect() {
        String stringToBeParsed = "-l -p 8080 -d /usr/logs";
        List<UnitParser> unitParsers = new ArrayList<>();
        unitParsers.add(new LoggingParser());
        unitParsers.add(new DirectoryParser());
        unitParsers.add(new PortParser());
        ArgumentParser argumentParser = new ArgumentParser(unitParsers);

        List<Argument> parsedArguments = argumentParser.parseArguments(stringToBeParsed);

        Assert.assertEquals(3, parsedArguments.size());
    }

}
