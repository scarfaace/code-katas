package operation.evaluator;

import operation.Operation;

public class MultiplicationEvaluator extends AbstractOperationEvaluator {

    @Override
    public Integer evaluate(Operation operation, Integer[] operands) {
        return operands[0] * operands[1];
    }

}
