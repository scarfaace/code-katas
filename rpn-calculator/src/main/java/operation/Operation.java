package operation;

import lombok.Getter;

@Getter
public enum Operation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String stringOperation;

    Operation(String stringOperation) {
        this.stringOperation = stringOperation;
    }

}
