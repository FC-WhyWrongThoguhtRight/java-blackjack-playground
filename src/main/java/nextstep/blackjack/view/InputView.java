package nextstep.blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import nextstep.blackjack.gamer.GamerDTO;
import nextstep.blackjack.code.Classification;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final String INVITE_USER_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String BATTING_MESSAGE = " :배팅 금액은?";
    public static final String STRING_REGEX = ",";

    public static List<GamerDTO> readPlayers(){
        List<GamerDTO> gamerDTOList = new ArrayList<>();
        System.out.println(INVITE_USER_MESSAGE);
        String menuNumber = readLine();

        for(String str : menuNumber.split(STRING_REGEX)){
            System.out.println(str + BATTING_MESSAGE);
            int batting = readBatting();
            gamerDTOList.add(new GamerDTO(str,batting, Classification.PLAYER));
        }

        return gamerDTOList;
    }

    public static boolean readYN(String user){
        System.out.println(user + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String yn = readLine();

        if(yn.equalsIgnoreCase("N")){
            return false;
        }

        return true;
    }

    public static boolean readDuller(String user){
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        String yn = readLine();

        if(yn.equalsIgnoreCase("N")){
            return false;
        }

        return true;
    }

    public static int readBatting() {
        String batting = readLine();
        return Integer.parseInt(batting);
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
