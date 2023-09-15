package nextstep.blackjack;

import nextstep.blackjack.gamer.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("게이머 객체 생성")
    void gamerObject(){
        GameService gameService = new GameService();

        gameService.startGame();
    }


}
