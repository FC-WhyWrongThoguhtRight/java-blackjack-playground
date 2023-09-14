package nextstep.blackjack.Exception.inputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatePlayersName {

    public static void validatePlayerNames(String input) {
        List<String> playerNames = Arrays.stream(input.split(",")).collect(Collectors.toList());
        for (String playerName : playerNames) {
            validateNameSize(playerName);
        }
        validateOneToSevenPlayer(playerNames);
        validateNameNotDuplicate(input);
    }

    private static void validateNameSize(String playerName) {
        if (playerName.replaceAll("\\s", "").length() == 0) {
            throw new IllegalArgumentException("[ERROR] 이름은 한 글자 이상이여야 합니다.");
        }
    }

    private static void validateOneToSevenPlayer(List<String> playerNames) {
        if (playerNames.size() < 1 || playerNames.size() > 7) {
            throw new IllegalArgumentException("\n[ERROR] 플레이어의 수는 1~7명 사이여야 합니다.\n");
        }
    }

    private static void validateNameNotDuplicate(String input){
        List<String> playerNames = Arrays.stream(input.split(",")).collect(Collectors.toList());
        if(playerNames.stream().distinct().count() != playerNames.size()){
            throw new IllegalArgumentException("\n[ERROR] 중복된 이름은 사용할 수 없습니다.\n");
        }
    }
}
