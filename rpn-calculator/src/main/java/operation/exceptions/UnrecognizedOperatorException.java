package operation.exceptions;

public class UnrecognizedOperatorException extends RuntimeException {

    public UnrecognizedOperatorException(String operator) {
        super(String.format("Unrecognized operator: %s", operator));
    }

}
