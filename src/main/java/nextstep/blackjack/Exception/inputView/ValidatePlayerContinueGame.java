package nextstep.blackjack.Exception.inputView;

public class ValidatePlayerContinueGame {

    public static void validateContinue(String input) {
        if (!"y".equalsIgnoreCase(input) && !"n".equalsIgnoreCase(input)) {
            throw new IllegalArgumentException("[ERROR] y/Y나 n/N만 입력해주세요.");
        }
    }

}
