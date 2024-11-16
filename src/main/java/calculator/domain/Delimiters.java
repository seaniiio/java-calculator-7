package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Delimiters {

    private List<Character> delimiters;

    private Delimiters() {}

    public Delimiters(Character customDelimiter) {
        this.delimiters = new ArrayList<>(List.of(',', ':'));
        if (customDelimiter == null) {
            return;
        }
        validate(customDelimiter);
        this.delimiters.add(customDelimiter);
    }

    public List<Character> getDelimiters() {
//        return new ArrayList<>(delimiters);
        return Collections.unmodifiableList(this.delimiters);
    }

    private void validate(Character customDelimiter) {
        if (List.of(',', ':').contains(customDelimiter)) {
            throw new IllegalArgumentException("이미 존재하는 구분자");
        }
    }
}
