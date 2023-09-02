package camp.next.domain.game;

import camp.next.domain.card.Card;
import camp.next.domain.game.calculation.CalculateStrategy;
import camp.next.domain.game.calculation.Calculator;
import camp.next.domain.game.distribution.Distributor;
import camp.next.domain.game.distribution.RandomDistributeStrategy;
import camp.next.domain.user.User;
import camp.next.domain.user.strategy.NormalPayStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int FIRST_DISTRIBUTION_TIME = 2;
    public static final String DEALER_NAME = "딜러";
    public static final int DEALER_BOUND = 16;
    public static final String DELIMITER = " - ";

    private final Distributor distributor;
    private final CalculateStrategy calculateStrategy;

    private List<User> users = new ArrayList<>();
    private User dealer = new User(DEALER_NAME, null);

    public Game() {
        this.distributor = new Distributor(new RandomDistributeStrategy());
        this.calculateStrategy = new Calculator();
    }

    public void createUser(String[] userNames) {
        for (String userName : userNames) {
            users.add(new User(userName, new NormalPayStrategy()));
        }
    }

    public User getUnbatUser() {
        for (User user : users) {
            if (!user.isBatted()) {
                return user;
            }
        }
        return null;
    }

    public void start() {
        for (int i = 0; i < FIRST_DISTRIBUTION_TIME; i++) {
            distribute(dealer);
            for (User user : users) {
                distribute(user);
            }
        }
    }

    public User getUndistributedUser() {
        for (User user : users) {
            if (!user.isDistributed()) {
                return user;
            }
        }
        return null;
    }

    public User getDealer() {
        return this.dealer;
    }

    public void distribute(User user) {
        Card uniqueCard = distributor.distribute();
        user.addCard(uniqueCard);
    }

    public String getUserNames() {
        StringBuilder sb = new StringBuilder();
        users.stream().forEach((user) -> sb.append(user.getName()).append(", "));
        return sb.substring(0, sb.length() - 2);
    }

    public String getAllCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(dealer.getCards()).append('\n');
        users.stream()
                .forEach((user) ->
                        sb.append(user.getCards()).append('\n'));
        return sb.toString();
    }

    public boolean requiresDealerDistributed() {
        return dealer.calculate(calculateStrategy) <= DEALER_BOUND;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(dealer.getCards()).append(DELIMITER).append(dealer.getResult()).append('\n');
        users.stream()
                .forEach((user) ->
                        sb.append(user.getCards()).append(DELIMITER).append(user.getResult()).append('\n'));
        return sb.toString();
    }

    public String getProfit() {
        StringBuilder sb = new StringBuilder();
        sb.append("## 최종 수익").append('\n');
        users.stream()
                .forEach((user) ->
                        sb.append(user.getName())
                                .append(DELIMITER).append(user.getProfit()).append('\n'));
        return sb.toString();
    }

    public void finish() {
        Integer dealerValue = dealer.calculate(calculateStrategy);
        dealer.setValue(dealerValue);
        for (User user : users) {
            user.setValue(user.calculate(calculateStrategy));
            user.setProfit(dealerValue);
        }
    }
}
