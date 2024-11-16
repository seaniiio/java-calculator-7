package calculator.service;

import calculator.domain.Delimiter;
import calculator.parser.Parser;

public class CalculatorService {

    private final Parser parser;
    private Delimiter delimiter;

    public CalculatorService(final Parser parser) {
        this.parser = parser;
    }

    public void calculate(String input) {
        Character customDelimiter = parser.splitCustomDelimiter(input);
        this.delimiter = new Delimiter(customDelimiter);


    }
}
