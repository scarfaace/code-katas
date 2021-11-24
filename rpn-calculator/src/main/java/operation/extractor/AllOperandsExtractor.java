package operation.extractor;

import lombok.NoArgsConstructor;
import operation.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@NoArgsConstructor
public class AllOperandsExtractor extends AbstractOperandsExtractor {

    protected void validateInput(Operation inputOperation, Stack<Integer> numbersStack) {
        if(numbersStack.size() == 0) {
            throw new RuntimeException("Too few numbers in the stack.");
        }
    }

    protected Integer[] customOperandsExtractor(Stack<Integer> numbersStack) {
        List<Integer> operands = new ArrayList<>();
        while(!numbersStack.isEmpty()) {
            Integer operand = numbersStack.pop();
            operands.add(operand);
        }
        return operands.toArray(Integer[]::new);
    }

}
