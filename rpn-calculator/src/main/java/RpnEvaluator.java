import lombok.Builder;
import operation.Operation;
import operation.evaluator.AbstractOperationEvaluator;
import operation.exceptions.UnrecognizedOperationException;
import operation.extractor.AbstractOperandsExtractor;

import java.util.Map;
import java.util.Stack;

@Builder
public class RpnEvaluator {

    private final Map<Operation, AbstractOperationEvaluator> operationEvaluators;
    private final Map<Operation, AbstractOperandsExtractor> operandsExtractors;

    public int evaluate(String[] tokens) {
        Stack<Integer> numbersStack = new Stack<>();
        for(String token: tokens) {
            if(isNumber(token)){
                numbersStack.push(castTokenToInteger(token));
            }
            if(isOperator(token)) {
                Integer result = performOperation(token, numbersStack);
                numbersStack.push(result);
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

    private Integer performOperation(String operationString, Stack<Integer> numbersStack) {
        try {
            Operation operation = Operation.getOperationByString(operationString);
            Integer[] operands = extractOperands(operation, numbersStack);
            return evaluateOperation(operation, operands);
        } catch (IllegalArgumentException exception) {
            throw new UnrecognizedOperationException(operationString);
        }
    }

    private Integer[] extractOperands(Operation operation, Stack<Integer> numbersStack) {
        AbstractOperandsExtractor operandsExtractor = operandsExtractors.get(operation);
        return operandsExtractor.extractOperands(operation, numbersStack);
    }

    private Integer evaluateOperation(Operation operation, Integer[] operands) {
        AbstractOperationEvaluator operationEvaluator = operationEvaluators.get(operation);
        return operationEvaluator.evaluate(operation, operands);
    }

}
