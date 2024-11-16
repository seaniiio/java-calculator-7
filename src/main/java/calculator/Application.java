package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorController calculatorController = appConfig.createCalculatorController();
        calculatorController.run();
    }
}
