package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import arguments.parser.arguments.PortArgument;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@NoArgsConstructor
public class PortParser implements UnitParser {

    private final String pattern = "(-p) (\\d+)";

    @Override
    public Argument parse(String cliParameters) {
        PortArgument directoryArgument = new PortArgument();

        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(cliParameters);
        if(matcher.find()) {
            Integer port = Integer.valueOf(matcher.group(2));
            directoryArgument.setValue(port);
        }
        return directoryArgument;
    }

}
