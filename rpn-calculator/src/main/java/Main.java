import operation.Operation;
import operation.evaluator.*;
import operation.extractor.AbstractOperandsExtractor;
import operation.extractor.AllOperandsExtractor;
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

        RpnEvaluator rpnEvaluator = RpnEvaluator.builder()
                .operationEvaluators(operationEvaluators)
                .operandsExtractors(operandsExtractors)
                .build();

        Integer result = rpnEvaluator.evaluate(args);
        System.out.println(result);
    }

}
