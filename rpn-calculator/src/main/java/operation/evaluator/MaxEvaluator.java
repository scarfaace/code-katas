package operation.evaluator;

import operation.Operation;

import java.util.Arrays;

public class MaxEvaluator extends AbstractOperationEvaluator {

    @Override
    public Integer evaluate(Operation operation, Integer[] operands) {
        return Arrays.stream(operands)
                .mapToInt(value -> value)
                .max()
                .getAsInt();
    }

}
