package blackjack.view;

import blackjack.model.person.Dealer;
import blackjack.model.person.Player;
import blackjack.model.person.Players;

public class ResultView {

    public static void resultFirstDraw(Dealer dealer, Players players){

        System.out.println("딜러와 " + players.getNames() + "에게 2장씩 나누었습니다.");
        showHand(dealer);
        for(Player person : players.getList()){
            showHand(person);
        }
    }

    public static void showHand(Player player) {
        System.out.println(player.toString());
    }

    public static void printDealerDraw() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void result(Dealer dealer, Players players) {
        showResult(dealer);
        for (Player person : players.getList()){
            showResult(person);
        }
    }

    public static void showResult(Player person){
        System.out.println(person.toString() + " - " + "결과: " + person.getSum() );
    }
}
