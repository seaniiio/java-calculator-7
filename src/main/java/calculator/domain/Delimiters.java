package calculator.domain;

import java.util.Collections;
import java.util.List;

public class Delimiters {

    private final List<Character> delimiters = List.of(',', ':');

    private Delimiters() {}

    public Delimiters(Character customDelimiter) {
        if (customDelimiter == null) {
            return;
        }
        validate(customDelimiter);
        delimiters.add(customDelimiter);
    }

    public List<Character> getDelimiters() {
//        return new ArrayList<>(delimiters);
        return Collections.unmodifiableList(delimiters);
    }

    private void validate(Character customDelimiter) {
        if (delimiters.contains(customDelimiter)) {
            throw new IllegalArgumentException("이미 존재하는 구분자");
        }
    }
}
