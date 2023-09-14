package nextstep.blackjack.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String receivePlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.next();
    }

    public static String receivePlayerBettingMoney(String name) {
        System.out.println(name + "님 얼마를 베팅하시겠습니까?");
        return scanner.next();
    }

    public static String receivePlayerContinue(String name) {
        System.out.println(name + "님 카드를 더 받으시겠습니까?(예는 Y/y,아니오는 N/n)");
        return scanner.next();
    }
}
