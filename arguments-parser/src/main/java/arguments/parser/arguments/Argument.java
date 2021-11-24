package arguments.parser.arguments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Argument {

    protected String name;
    protected Object value;

    public String toString() {
        return name + ": " + value;
    }

}
