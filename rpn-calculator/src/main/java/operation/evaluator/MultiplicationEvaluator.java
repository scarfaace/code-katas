package operation.evaluator;

import operation.Operation;

public class MultiplicationEvaluator extends AbstractOperationEvaluator {

    public MultiplicationEvaluator() {
        super(Operation.MULTIPLY);
    }

    @Override
    public Integer evaluate(String operation, Integer operand1, Integer operand2) {
        return operand1 * operand2;
    }

}
