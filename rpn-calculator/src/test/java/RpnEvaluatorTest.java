import operation.Operation;
import operation.evaluator.*;
import operation.extractor.AbstractOperandsExtractor;
import operation.extractor.AllOperandsExtractor;
import operation.extractor.BinaryOperationOperandsExtractor;
import operation.extractor.UnaryOperationOperandsExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RpnEvaluatorTest {

    private RpnEvaluator rpnEvaluator;

    @BeforeEach
    public void setup() {
        Map<Operation, AbstractOperationEvaluator> operationEvaluators = Map.of(
                Operation.ADD, new AdditionEvaluator(),
                Operation.SUBTRACT, new SubtractionEvaluator(),
                Operation.MULTIPLY, new MultiplicationEvaluator(),
                Operation.DIVIDE, new DivisionEvaluator(),
                Operation.SQRT, new SqrtEvaluator(),
                Operation.MAX, new MaxEvaluator()
        );

        BinaryOperationOperandsExtractor binaryOperationOperandsExtractor = new BinaryOperationOperandsExtractor();
        UnaryOperationOperandsExtractor unaryOperationOperandsExtractor = new UnaryOperationOperandsExtractor();
        AllOperandsExtractor allOperandsExtractor = new AllOperandsExtractor();
        Map<Operation, AbstractOperandsExtractor> operandsExtractors = Map.of(
                Operation.ADD, binaryOperationOperandsExtractor,
                Operation.SUBTRACT, binaryOperationOperandsExtractor,
                Operation.MULTIPLY, binaryOperationOperandsExtractor,
                Operation.DIVIDE, binaryOperationOperandsExtractor,
                Operation.SQRT, unaryOperationOperandsExtractor,
                Operation.MAX, allOperandsExtractor
        );

        rpnEvaluator = RpnEvaluator.builder()
                .operationEvaluators(operationEvaluators)
                .operandsExtractors(operandsExtractors)
                .build();
    }

    @Test
    public void should_return_4() {
        String[] tokens = { "20", "5", "/" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 4;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_3() {
        String[] tokens = { "4", "2", "+", "3", "-" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 3;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_141() {
        String[] tokens = { "3", "5", "8", "*", "7", "+", "*" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 141;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_5() {
        String[] tokens = { "25", "SQRT" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 5;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_9() {
        String[] tokens = { "5", "3", "4", "2", "9", "1", "MAX" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 9;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_10() {
        String[] tokens = { "4", "5", "MAX", "1", "2", "MAX", "2", "*" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 10;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_throw_when_0th_element_in_input_array_is_operation() {
        String[] tokens = { "+", "1", "2" };

        assertThrows(RuntimeException.class, () -> rpnEvaluator.evaluate(tokens));
    }

    @Test
    public void should_throw_when_1st_element_in_input_array_is_operation() {
        String[] tokens = { "1", "+", "2" };

        assertThrows(RuntimeException.class, () -> rpnEvaluator.evaluate(tokens));
    }

    @Test
    public void should_throw_when_operator_is_not_recognized() {
        String[] tokens = { "1", "2", "3", "+", "%" };

        assertThrows(RuntimeException.class, () -> rpnEvaluator.evaluate(tokens));
    }

}
