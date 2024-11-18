package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1:2:3", // 음수 입력
            "-1;2;3", // 지정하지 않은 구분자
            "1:2'3//'\\n", // 커스텀 구분자 뒤에 입력
            "//\\n1:2:3", // 커스텀 구분자 입력하지 않음
    })
    void 예외_통합_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_빼기_기호_테스트() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3" );
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
