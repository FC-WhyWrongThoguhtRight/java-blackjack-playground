package nextstep.blackjack.controller;

import nextstep.blackjack.Exception.inputView.ValidatePlayerBettingMoney;
import nextstep.blackjack.Exception.inputView.ValidatePlayerContinueGame;
import nextstep.blackjack.Exception.inputView.ValidatePlayersName;
import nextstep.blackjack.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    public static List<String> getPlayerNames() {
        try {
            String input = InputView.receivePlayerNames();
            ValidatePlayersName.validatePlayerNames(input);
            return Arrays.stream(input.split(",")).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerNames();
        }
    }

    public static int getPlayerBettingMoney(String name) {
        try {
            String input = InputView.receivePlayerBettingMoney(name);
            return ValidatePlayerBettingMoney.validateBettingMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerBettingMoney(name);
        }
    }

    public static String getPlayerContinue(String name) {
        try {
            String input = InputView.receivePlayerContinue(name);
            ValidatePlayerContinueGame.validateContinue(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerContinue(name);
        }
    }

}
