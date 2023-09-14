package nextstep.blackjack.Exception.inputView;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatePlayerBettingMoneyTest {

    @Test
    @DisplayName("숫자로만 이루어진 것이 아니므로 오류를 던진다.")
    void test3_Error() {
        String input = "1000a";
        assertThrows(IllegalArgumentException.class,
            () -> ValidatePlayerBettingMoney.validateBettingMoney(input));
    }
}