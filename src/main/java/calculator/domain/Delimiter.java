package calculator.domain;

import java.util.List;

public class Delimiter {

    private final List<Character> delimiters = List.of(',', ':');

    private Delimiter() {}

    public Delimiter(Character customDelimiter) {
        if (customDelimiter == null) {
            return;
        }
        validate(customDelimiter);
        delimiters.add(customDelimiter);
    }

    private void validate(Character customDelimiter) {
        if (delimiters.contains(customDelimiter)) {
            throw new IllegalArgumentException("이미 존재하는 구분자");
        }
    }
}
