package operation.exceptions;

public class UnrecognizedOperationException extends RuntimeException {

    public UnrecognizedOperationException(String operation) {
        super(String.format("Unrecognized operation: %s", operation));
    }

}
