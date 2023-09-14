package nextstep.blackjack.Exception.inputView;

public class ValidatePlayerBettingMoney {

    public static int validateBettingMoney(String input) {
        return onlyNumber(input);
    }

    private static int onlyNumber(String input) {
        if (input.matches("^[0-9]+$")) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }
}
