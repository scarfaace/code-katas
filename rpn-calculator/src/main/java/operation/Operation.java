package operation;

import lombok.Getter;
import operation.exceptions.UnrecognizedOperationException;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Operation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("SQRT");

    private final String stringOperation;

    Operation(String stringOperation) {
        this.stringOperation = stringOperation;
    }

    public static Operation getOperationByString(String givenOperationString) {
        Optional<Operation> foundOperation = Arrays.stream(Operation.values())
                .filter(operation -> operation.getStringOperation().equals(givenOperationString))
                .findFirst();
        if(foundOperation.isPresent()) {
            return foundOperation.get();
        }
        throw new UnrecognizedOperationException(givenOperationString);
    }

}
