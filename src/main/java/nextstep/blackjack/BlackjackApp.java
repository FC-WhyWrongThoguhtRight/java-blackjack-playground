package nextstep.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import nextstep.blackjack.domain.Dealer;
import nextstep.blackjack.domain.Player;

public class BlackjackApp {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String[] playerNames = readLine().split(",");

        int[] playerBets = new int[playerNames.length];
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerBets.length; i++) {
            System.out.printf("%s의 배팅 금액은?\n", playerNames[i]);
            playerBets[i] = Integer.parseInt(readLine());

            players.add(new Player(playerNames[i], playerBets[i]));
        }

        System.out.printf("\n딜러와 %s에게 2장을 나누었습니다.\n", String.join(", ", playerNames));
        // 카드 주기

        players.forEach(player -> System.out.printf("%s카드: %s\n", player.getName(), player.getCardsStatus()));
        System.out.println();

        Dealer dealer = new Dealer();
        while (players.stream().anyMatch(Player::canPick) || dealer.shouldPick()) {
            for (Player player : players) {
                if (player.canPick()) {
                    System.out.printf("%s는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)\n");
                    String answer = readLine();
                    if ("y".equals(answer)) {
                        // 한장 더 받기
                        // 카드 목록 또 보여주기
                    } else {
                        // 더 뽑을 수 없도록 하기
                    }
                }
            }

            if (dealer.shouldPick()) {
                // 한장 더 받기
                // 카드 목록 또 보여주기
            }
        }

        System.out.println("딜러 카드: %s - 결과: %d\n", dealer.getCardsStatus(), dealer.getScore());
        for (Player player : players) {
            System.out.printf("%s 카드: %s - 결과: %d\n", player.getName(), player.getCardsStatus(), player.getScore());
        }

        System.out.println("\n## 최종 수익\n");
        // 최종수익
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
