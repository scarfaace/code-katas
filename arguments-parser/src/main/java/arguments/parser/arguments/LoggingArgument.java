package arguments.parser.arguments;

public class LoggingArgument extends Argument {

    private static final boolean DEFAULT_VALUE = false;

    public LoggingArgument() {
        this.name = "Logging";
        this.value = DEFAULT_VALUE;
    }

}
