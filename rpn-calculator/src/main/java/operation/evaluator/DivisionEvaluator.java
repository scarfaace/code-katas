package operation.evaluator;

import operation.Operation;

public class DivisionEvaluator extends AbstractOperationEvaluator {

    public DivisionEvaluator() {
        super(Operation.DIVIDE);
    }

    @Override
    public Integer evaluate(String operation, Integer operand1, Integer operand2) {
        return operand1 / operand2;
    }

}
