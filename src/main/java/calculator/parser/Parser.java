package calculator.parser;

import java.util.regex.Pattern;

public class Parser {

    public Character splitCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            Character customDelimiter = input.charAt(2);
            if (!input.substring(3, 5).equals("\\n")) {
                throw new IllegalArgumentException("입력 형식 오류");
            }
            return customDelimiter;
        }
        return null;
    }

    public void parseInput(String input) {

    }
}
