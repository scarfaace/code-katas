package operation.evaluator;

import lombok.AllArgsConstructor;
import operation.Operation;

@AllArgsConstructor
public abstract class AbstractOperationEvaluator {

    public abstract Integer evaluate(Operation operation, Integer[] operands);

}
