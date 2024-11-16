package calculator.parser;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    private Parser parser = new Parser();

    @DisplayName("커스텀 연산자가 존재하는 경우, 구분하는지 확인")
    @Test
    void 커스텀_연산자_구분_테스트_1() {
        String input = "//$\\n1:2$3";

        assertThat(parser.splitCustomDelimiter(input))
                .isEqualTo('$');
    }

    @DisplayName("커스텀 연산자가 존재하지 않는 경우, null 확인")
    @Test
    void 커스텀_연산자_구분_테스트_2() {
        String input = "1:2:3";

        assertThat(parser.splitCustomDelimiter(input))
                .isEqualTo(null);
    }

    @DisplayName("커스텀 연산자 입력 형식이 잘못된 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "//^^\\n1:2^^3", // 문자가 아닌 경우
            "//\\n1:2^^3", // 구분자가 입력되지 않은 경우
    })
    void 커스텀_연산자_구분_테스트_2(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> parser.splitCustomDelimiter(input));
    }
}
