package operation.evaluator;

import operation.Operation;

public class SqrtEvaluator extends AbstractOperationEvaluator {

    @Override
    public Integer evaluate(Operation operation, Integer[] operands) {
        return (int)Math.sqrt(operands[0]);
    }

}
