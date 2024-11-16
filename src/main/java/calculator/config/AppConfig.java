package calculator.config;

import calculator.controller.CalculatorController;
import calculator.parser.Parser;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController createCalculatorController() {
        return new CalculatorController(createInputView(), createOutputView(), createCalculatorService());
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    private CalculatorService createCalculatorService() {
        return new CalculatorService(createParser());
    }

    private Parser createParser() {
        return new Parser();
    }
}
