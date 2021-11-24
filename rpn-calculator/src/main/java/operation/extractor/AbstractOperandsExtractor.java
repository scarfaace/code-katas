package operation.extractor;

import operation.Operation;

import java.util.Stack;

public abstract class AbstractOperandsExtractor {

    public Integer[] extractOperands(Operation operation, Stack<Integer> numbersStack) {
        validateInput(operation, numbersStack);
        return customOperandsExtractor(numbersStack);
    }

    protected abstract void validateInput(Operation inputOperation, Stack<Integer> numbersStack);

    protected abstract Integer[] customOperandsExtractor(Stack<Integer> numbersStack);

}
