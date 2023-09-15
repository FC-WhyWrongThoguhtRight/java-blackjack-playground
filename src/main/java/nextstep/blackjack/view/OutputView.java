package nextstep.blackjack.view;

import nextstep.blackjack.gamer.Gamers;

public class OutputView {

    public static final String FIRST_SHOW_MESSAGE = "딜러와 플레이어에게 2장의 나누었습니다.";

    public static void showCards(Gamers gamers){
        System.out.println(FIRST_SHOW_MESSAGE);
        System.out.println(gamers.toString());
    }

}
