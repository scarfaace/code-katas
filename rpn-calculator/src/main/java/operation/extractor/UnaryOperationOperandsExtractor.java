package operation.extractor;

import lombok.NoArgsConstructor;
import operation.Operation;

import java.util.Stack;

@NoArgsConstructor
public class UnaryOperationOperandsExtractor extends AbstractOperandsExtractor {

    protected void validateInput(Operation inputOperation, Stack<Integer> numbersStack) {
        if(numbersStack.size() == 0) {
            throw new RuntimeException("Too few numbers in the stack.");
        }
    }

    protected Integer[] customOperandsExtractor(Stack<Integer> numbersStack) {
        Integer operand = numbersStack.pop();
        return new Integer[] {operand};
    }

}
