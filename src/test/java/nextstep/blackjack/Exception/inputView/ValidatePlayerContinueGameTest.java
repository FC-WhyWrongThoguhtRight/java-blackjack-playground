package nextstep.blackjack.Exception.inputView;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatePlayerContinueGameTest {

    @Test
    @DisplayName("Y/y 이므로 에러를 발생하지 않는다.")
    void test1() {
        assertDoesNotThrow(() -> ValidatePlayerContinueGame.validateContinue("y"));
        assertDoesNotThrow(() -> ValidatePlayerContinueGame.validateContinue("Y"));
    }

    @Test
    @DisplayName("N/n 이므로 에러를 발생하지 않는다.")
    void test2() {
        assertDoesNotThrow(() -> ValidatePlayerContinueGame.validateContinue("n"));
        assertDoesNotThrow(() -> ValidatePlayerContinueGame.validateContinue("N"));
    }

    @Test
    @DisplayName("Y/y or N/n이 아니므로 에러를 발생한다.")
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> ValidatePlayerContinueGame.validateContinue("t"));
    }
}