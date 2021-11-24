package operation.extractor;

import lombok.NoArgsConstructor;
import operation.Operation;

import java.util.Stack;

@NoArgsConstructor
public class BinaryOperationOperandsExtractor extends AbstractOperandsExtractor {

    protected void validateInput(Operation inputOperation, Stack<Integer> numbersStack) {
        if(numbersStack.size() < 2) {
            throw new RuntimeException("Too few numbers in the stack.");
        }
    }

    protected Integer[] customOperandsExtractor(Stack<Integer> numbersStack) {
        Integer operand2 = numbersStack.pop();
        Integer operand1 = numbersStack.pop();
        return new Integer[] {operand1, operand2};
    }

}
