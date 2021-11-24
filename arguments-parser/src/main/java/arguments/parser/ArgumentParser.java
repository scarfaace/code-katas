package arguments.parser;

import arguments.parser.arguments.Argument;
import arguments.parser.unit_parser.UnitParser;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class ArgumentParser {

    private final List<UnitParser> unitParsers;

    public List<Argument> parseArguments(String stringToBeParsed) {
        List<Argument> parsedArguments = new ArrayList<>();
        unitParsers.forEach(unitParser -> parsedArguments.add(unitParser.parse(stringToBeParsed)));
        return parsedArguments;
    }

}
