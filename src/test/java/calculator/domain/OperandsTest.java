package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperandsTest {

    @Test
    public void 음수_피연산자_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Operands.createOperands(List.of("-3", "1")));
    }

    @Test
    public void 피연산자_타입_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Operands.createOperands(List.of("일", "이")));
    }

    @Test
    public void 합_계산_테스트() {
        Operands operands = Operands.createOperands(List.of("1", "2", "3"));
        int expected = 6;

        Assertions.assertThat(operands.getSum())
                .isEqualTo(expected);
    }
}
