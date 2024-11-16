package calculator.service;

import calculator.parser.Parser;

public class CalculatorService {

    private final Parser parser;

    public CalculatorService(final Parser parser) {
        this.parser = parser;
    }

    public void calculate(String input) {
        Character customDelimiter = parser.splitCustomDelimiter(input);

    }
}
