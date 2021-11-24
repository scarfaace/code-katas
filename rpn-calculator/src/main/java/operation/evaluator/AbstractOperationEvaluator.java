package operation.evaluator;

import lombok.AllArgsConstructor;
import operation.Operation;

@AllArgsConstructor
public abstract class AbstractOperationEvaluator {

    protected final Operation operation;


    public boolean shouldEvaluate(String operation) {
        return isMyOperation(operation);
    }

    protected boolean isMyOperation(String stringOperation) {
        return this.operation.getStringOperation().equals(stringOperation);
    }

    public abstract Integer evaluate(String operation, Integer operand1, Integer operand2);

}
