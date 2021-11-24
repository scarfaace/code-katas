import operation.evaluator.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<AbstractOperationEvaluator> operationEvaluators = List.of(
                new AdditionEvaluator(),
                new SubtractionEvaluator(),
                new MultiplicationEvaluator(),
                new DivisionEvaluator()
        );
        RpnEvaluator rpnEvaluator = new RpnEvaluator(operationEvaluators);

        Integer result = rpnEvaluator.evaluate(args);
        System.out.println(result);
    }

}
