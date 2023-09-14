package nextstep.blackjack.Exception.inputView;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatePlayersNameTest {

    @Test
    @DisplayName("이름 하나를 적었으므로 오류가 뜨지 않는다.")
    void test1_No_Error() {
        String input = "one";
        assertDoesNotThrow(() -> ValidatePlayersName.validatePlayerNames(input));
    }

    @Test
    @DisplayName("이름 두 개를 적었으므로 오류가 뜨지 않는다.")
    void test2_No_Error() {
        String input = "one,two";
        assertDoesNotThrow(() -> ValidatePlayersName.validatePlayerNames(input));
    }

    @Test
    @DisplayName("플레이어가 없기 때문에 에러를 던지게 된다.")
    void test1_Error() {
        String input = ",";
        assertThrows(IllegalArgumentException.class, () -> ValidatePlayersName.validatePlayerNames(input));
    }

    @Test
    @DisplayName("이름이 공백이면 에러를 던지게 된다.")
    void test2_Error() {
        String input = " ";
        assertThrows(IllegalArgumentException.class, () -> ValidatePlayersName.validatePlayerNames(input));
    }

    @Test
    @DisplayName("여러 이름 중 하나의 이름이라도 공백이면 에러를 던지게 된다.")
    void test3_Error() {
        String input = "one,two, ";
        assertThrows(IllegalArgumentException.class, () -> ValidatePlayersName.validatePlayerNames(input));
    }

    @Test
    @DisplayName("플레이어가 7명을 넘었기 때문에 에러를 던지게 된다.")
    void test4_Error() {
        String input = "one,two,one,three,four,five,six,seven,eight";
        assertThrows(IllegalArgumentException.class, () -> ValidatePlayersName.validatePlayerNames(input));
    }
}