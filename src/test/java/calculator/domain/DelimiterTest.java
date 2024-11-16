package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("커스텀 연산자가 기본 연산자와 중복되는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(chars = {':', ','})
    public void 커스텀_연산자_검증_테스트(Character customDelimiter) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Delimiters(customDelimiter));
    }
}
