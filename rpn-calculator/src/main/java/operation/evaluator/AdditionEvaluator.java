package operation.evaluator;

import operation.Operation;

public class AdditionEvaluator extends AbstractOperationEvaluator {

    public AdditionEvaluator() {
        super(Operation.ADD);
    }

    @Override
    public Integer evaluate(String operation, Integer operand1, Integer operand2) {
        return operand1 + operand2;
    }

}
