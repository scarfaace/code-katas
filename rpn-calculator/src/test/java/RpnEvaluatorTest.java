import operation.evaluator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RpnEvaluatorTest {

    private RpnEvaluator rpnEvaluator;

    @BeforeEach
    public void setup() {
        List<AbstractOperationEvaluator> operationEvaluators = List.of(
                new AdditionEvaluator(),
                new SubtractionEvaluator(),
                new MultiplicationEvaluator(),
                new DivisionEvaluator()
        );
        rpnEvaluator = new RpnEvaluator(operationEvaluators);
    }

    @Test
    public void should_return_9() {
        String[] tokens = { "20", "5", "/" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 4;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_2() {
        String[] tokens = { "4", "2", "+", "3", "-" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 3;
        assertEquals(expectedValue, returnValue);
    }

    @Test
    public void should_return_minus_9() {
        String[] tokens = { "3", "5", "8", "*", "7", "+", "*" };

        int returnValue = rpnEvaluator.evaluate(tokens);

        Integer expectedValue = 141;
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
