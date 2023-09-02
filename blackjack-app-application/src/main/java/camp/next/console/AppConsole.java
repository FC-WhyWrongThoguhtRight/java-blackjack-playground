package camp.next.console;

import camp.next.domain.game.Game;
import camp.next.domain.user.User;
import camp.next.exception.input.InvalidBatAmountException;
import camp.next.exception.input.InvalidUserNameException;
import camp.next.validator.InputParser;

import static camp.next.constant.BlackJackConst.DEALER_BOUND;

public class AppConsole {
    private static final String USERNAME_INPUT_DISPLAY = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INVALID_INPUT_DISPLAY = "잘못된 형식의 입력입니다. 다시 입력해주세요";
    private static final String BAT_INPUT_DISPLAY = "%s의 배팅 금액은?";
    private static final String INVALID_NUMBER_DISPLAY = "숫자를 입력해주세요.";
    public static final String START_GAME_DISPLAY = "딜러와 %s에게 2장의 나누었습니다.";
    public static final String DISTRIBUTE_DISPLAY = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    public static final String DEALER_DISTRIBUTE_DISPLAY = "딜러는 %d이하라 한장의 카드를 더 받았습니다.";

    private final TextOutput output;

    private Processor processor;
    private Game game;
    private boolean isShutdown = false;

    public AppConsole() {
        this.output = new TextOutput();
        this.processor = getUserName();
    }

    private Processor getUserName() {
        output.println(USERNAME_INPUT_DISPLAY);

        return (String input) -> {
            String[] userNames;
            try {
                userNames = InputParser.getUserName(input);
            } catch (InvalidUserNameException e) {
                output.println(INVALID_INPUT_DISPLAY);
                return this.processor;
            }
            game = new Game();
            game.createUser(userNames);
            return getBat();
        };
    }

    private Processor getBat() {
        User unbatUser = game.getUnbatUser();
        if (unbatUser != null) {
            output.println(String.format(BAT_INPUT_DISPLAY, unbatUser.getName()));

            return (String input) -> {
                Integer batAmount;
                try {
                    batAmount = InputParser.getBatAmount(input);
                } catch (InvalidBatAmountException e) {
                    output.println(INVALID_NUMBER_DISPLAY);
                    return this.processor;
                }
                unbatUser.setBatAmount(batAmount);
                return getBat();
            };
        }
        return startGame();
    }

    private Processor startGame() {
        game.start();
        output.println(String.format(START_GAME_DISPLAY, game.getUserNames()));
        output.println(game.getAllCards());
        return distributeCard();
    }

    private Processor distributeCard() {
        User undistributedUser = game.getUndistributedUser();
        if (undistributedUser != null) {
            output.println(String.format(DISTRIBUTE_DISPLAY, undistributedUser.getName()));

            return (String input) -> {
                switch (input) {
                    case "y":
                    case "Y":
                        game.distribute(undistributedUser);
                        output.println(undistributedUser.getCards());
                        return distributeCard();
                    case "n":
                    case "N":
                        undistributedUser.doneDistribution();
                        return distributeCard();
                }
                output.println(INVALID_INPUT_DISPLAY);
                return this.processor;
            };
        }
        return finishGame();
    }

    private Processor finishGame() {
        System.out.println("00");
        while (game.requiresDealerDistributed()) {
            System.out.println("11");
            game.distribute(game.getDealer());
            System.out.println("22");
            output.println(String.format(DEALER_DISTRIBUTE_DISPLAY, DEALER_BOUND));
            System.out.println("33");
        }
        System.out.println("44");
        game.finish();
        System.out.println("55");
        output.println(game.getResult());
        output.println(game.getProfit());
        shutDown();
        return null;
    }

    private void shutDown() {
        isShutdown = true;
    }

    public boolean isShutdown() {
        return this.isShutdown;
    }

    public void process(String input) {
        this.processor = this.processor.run(input);
    }

    public String flush() {
        return output.flush();
    }
}
