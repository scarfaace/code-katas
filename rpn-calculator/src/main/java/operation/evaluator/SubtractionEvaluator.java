package operation.evaluator;

import operation.Operation;

public class SubtractionEvaluator extends AbstractOperationEvaluator {

    public SubtractionEvaluator() {
        super(Operation.SUBTRACT);
    }

    @Override
    public Integer evaluate(String operation, Integer operand1, Integer operand2) {
        return operand1 - operand2;
    }

}
