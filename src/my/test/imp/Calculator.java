package my.test.imp;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public static int calculate(int op1, int op2, String operator) {
        BiFunction<Integer, Integer, Integer> operation = OPERATIONS.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
        return operation.apply(op1, op2);
    }

    static void main() {
        Calculator cal = new Calculator();
        System.out.println(Calculator.calculate(2, 5, "*"));
    }
}