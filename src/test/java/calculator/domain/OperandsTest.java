package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

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
}
