package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import arguments.parser.arguments.LoggingArgument;

public class LoggingParser implements UnitParser {

    public Argument parse(String cliParameters) {
        LoggingArgument loggingArgument = new LoggingArgument();
        if(cliParameters.contains("-l")) {
            loggingArgument.setValue(true);
        }
        return loggingArgument;
    }

}
