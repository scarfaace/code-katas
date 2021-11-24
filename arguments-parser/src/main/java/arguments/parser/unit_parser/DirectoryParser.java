package arguments.parser.unit_parser;

import arguments.parser.arguments.Argument;
import arguments.parser.arguments.DirectoryArgument;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class DirectoryParser implements UnitParser {

    private final String ARGUMENT_PATTERN = "(-d) ((?:\\/\\w+)+)\\/?";

    @Override
    public Argument parse(String cliParameters) {
        DirectoryArgument directoryArgument = new DirectoryArgument();

        Pattern pattern = Pattern.compile(this.ARGUMENT_PATTERN);
        Matcher matcher = pattern.matcher(cliParameters);
        if(matcher.find()) {
            String path = matcher.group(2);
            directoryArgument.setValue(path);
        }
        return directoryArgument;
    }

}
