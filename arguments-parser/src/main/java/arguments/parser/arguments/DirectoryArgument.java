package arguments.parser.arguments;

public class DirectoryArgument extends Argument {

    private static final String DEFAULT_VALUE = "";

    public DirectoryArgument() {
        this.name = "Directory";
        this.value = DEFAULT_VALUE;
    }

}
