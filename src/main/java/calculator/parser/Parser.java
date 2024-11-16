package calculator.parser;

import java.util.List;

public class Parser {

    private String excludeCustomDelimiter;

    public Character splitCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            Character customDelimiter = input.charAt(2);
            if (!input.substring(3, 5).equals("\\n")) {
                throw new IllegalArgumentException("입력 형식 오류");
            }
            excludeCustomDelimiter = input.substring(5);
            return customDelimiter;
        }
        excludeCustomDelimiter = input;
        return null;
    }

    public List<String> splitOperands(List<Character> delimiters) {
        StringBuilder delimiterRegexBuilder = new StringBuilder();

        for (Character delimiter : delimiters) {
            delimiterRegexBuilder.append("\\");
            delimiterRegexBuilder.append(delimiter);
            delimiterRegexBuilder.append("|");
        }

        String delimiterRegex = delimiterRegexBuilder.substring(0, delimiterRegexBuilder.length() - 1);
        return List.of(excludeCustomDelimiter.split(delimiterRegex));
    }
}
