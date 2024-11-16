package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private final List<Integer> operands;

    private Operands(List<Integer> operands) {
        this.operands = operands;
    }

    public static Operands createOperands(List<String> operandsRaw) {
        validate(operandsRaw);
        List<Integer> operands = parse(operandsRaw);
        return new Operands(operands);
    }

    private static void validate(List<String> operandsRaw) {
        for (String operand : operandsRaw) {
            int parsedOperand = validateFormat(operand);
            validatePositive(parsedOperand);
        }
    }

    private static int validateFormat(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산자가 숫자가 아님");
        }
    }

    private static void validatePositive(int operand) {
        if (operand <= 0) {
            throw new IllegalArgumentException("연산자가 양수가 아님");
        }
    }

    private static List<Integer> parse(List<String> operandsRaw) {
        List<Integer> operands = new ArrayList<>();
        for (String operandRaw : operandsRaw) {
            operands.add(Integer.parseInt(operandRaw));
        }
        return operands;
    }
}
