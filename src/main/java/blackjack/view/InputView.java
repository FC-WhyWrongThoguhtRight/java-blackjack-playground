package blackjack.view;

import blackjack.person.Person;
import blackjack.person.Players;
import java.util.Scanner;

public class InputView {

    private final static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }


    public static String inputPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리");
        return sc.nextLine();
    }

    public static Integer inputBatting(String name){
        System.out.println(name + "의 배팅 금액은?");
        return Integer.parseInt(sc.nextLine());
    }

    public static boolean inputMoreDraw(String name) {
        System.out.println(name + "은 한장의 카드를 더 받겠습니까?(y/n)");
        return sc.nextLine().equalsIgnoreCase("y");
    }
}
