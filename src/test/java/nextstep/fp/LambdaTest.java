package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    @DisplayName("리스트 안에 있는 모든 수의 합")
    public void sumAll() throws Exception {
        int sum = Lambda.sumAllOnConditional(numbers, number -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("리스트 안에 있는 모든 짝수의 합")
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllOnConditional(numbers, number -> number%2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    @DisplayName("리스트 안에 있는 3 이상의 모든 수의 합")
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOnConditional(numbers, number -> number > 3);
        assertThat(sum).isEqualTo(15);
    }
}
