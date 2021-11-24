package arguments.parser;

import arguments.parser.arguments.Argument;
import arguments.parser.unit_parser.UnitParser;
import arguments.parser.unit_parser.DirectoryParser;
import arguments.parser.unit_parser.LoggingParser;
import arguments.parser.unit_parser.PortParser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String stringToBeParsed = args[1];

        List<UnitParser> unitParsers = new ArrayList<>();
        unitParsers.add(new LoggingParser());
        unitParsers.add(new DirectoryParser());
        unitParsers.add(new PortParser());

        ArgumentParser argumentParser = new ArgumentParser(unitParsers);

        List<Argument> parsedArguments = argumentParser.parseArguments(stringToBeParsed);

        System.out.println(parsedArguments.toString());
    }

}
