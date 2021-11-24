import lombok.Builder;
import operation.Operation;
import operation.evaluator.AbstractOperationEvaluator;
import operation.exceptions.UnrecognizedOperatorException;

import java.util.List;
import java.util.Stack;

@Builder
public class RpnEvaluator {

    private final List<AbstractOperationEvaluator> operationEvaluators;

    public int evaluate(String[] tokens) {
        Stack<Integer> numbersStack = new Stack<>();
        for(String token: tokens) {
            if(isNumber(token)){
                numbersStack.push(castTokenToInteger(token));
            }
            if(isOperator(token)) {
                if(numbersStack.size() == 0 || numbersStack.size() == 1) {
                    throw new RuntimeException("Two operands needed for a binary operation.");
                }
                Integer operand2 = numbersStack.pop();
                Integer operand1 = numbersStack.pop();
                numbersStack.push(performOperation(token, operand1, operand2));
            }
        }
        return numbersStack.pop();
    }


    private Integer castTokenToInteger(String token) {
        return Integer.parseInt(token);
    }


    private boolean isNumber(String token) {
        return !isOperator(token);
    }


    private static boolean isOperator(String token) {
        for(Operation operation: Operation.values()) {
            if(operation.getStringOperation().equals(token)) {
                return true;
            }
        }
        return false;
    }

    private Integer performOperation(String operation, Integer operand1, Integer operand2) {
        AbstractOperationEvaluator operationEvaluator = chooseOperationEvaluator(operation);
        return operationEvaluator.evaluate(operation, operand1, operand2);
    }

    private AbstractOperationEvaluator chooseOperationEvaluator(String operation) {
        for (AbstractOperationEvaluator evaluator : operationEvaluators) {
            if (evaluator.shouldEvaluate(operation)) {
                return evaluator;
            }
        }
        throw new UnrecognizedOperatorException("Unrecognized operator.");
    }

}
