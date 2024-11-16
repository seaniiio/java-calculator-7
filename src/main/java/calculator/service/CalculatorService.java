package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Operands;
import calculator.parser.Parser;
import java.util.List;

public class CalculatorService {

    private final Parser parser;
    private Delimiters delimiter;
    private Operands operands;

    public CalculatorService(final Parser parser) {
        this.parser = parser;
    }

    public void calculate(String input) {
        Character customDelimiter = parser.splitCustomDelimiter(input);
        this.delimiter = new Delimiters(customDelimiter);

        List<Character> delimiters = this.delimiter.getDelimiters();
        List<String> operandsRaw = parser.splitOperands(delimiters);
        this.operands = Operands.createOperands(operandsRaw);
    }
}
