import operation.Operation;
import operation.evaluator.*;
import operation.extractor.AbstractOperandsExtractor;
import operation.extractor.BinaryOperationOperandsExtractor;
import operation.extractor.UnaryOperationOperandsExtractor;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Operation, AbstractOperationEvaluator> operationEvaluators = Map.of(
                Operation.ADD, new AdditionEvaluator(),
                Operation.SUBTRACT, new SubtractionEvaluator(),
                Operation.MULTIPLY, new MultiplicationEvaluator(),
                Operation.DIVIDE, new DivisionEvaluator(),
                Operation.SQRT, new SqrtEvaluator()
        );

        BinaryOperationOperandsExtractor binaryOperationOperandsExtractor = new BinaryOperationOperandsExtractor();
        UnaryOperationOperandsExtractor unaryOperationOperandsExtractor = new UnaryOperationOperandsExtractor();
        Map<Operation, AbstractOperandsExtractor> operandsExtractors = Map.of(
                Operation.ADD, binaryOperationOperandsExtractor,
                Operation.SUBTRACT, binaryOperationOperandsExtractor,
                Operation.MULTIPLY, binaryOperationOperandsExtractor,
                Operation.DIVIDE, binaryOperationOperandsExtractor,
                Operation.SQRT, unaryOperationOperandsExtractor
        );

        RpnEvaluator rpnEvaluator = RpnEvaluator.builder()
                .operationEvaluators(operationEvaluators)
                .operandsExtractors(operandsExtractors)
                .build();

        Integer result = rpnEvaluator.evaluate(args);
        System.out.println(result);
    }

}
