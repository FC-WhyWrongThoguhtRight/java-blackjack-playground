package camp.next.domain.game;

import camp.next.domain.card.Card;
import camp.next.domain.game.calculation.CalculateStrategy;
import camp.next.domain.game.distribution.Distributor;
import camp.next.domain.user.User;

import java.util.ArrayList;
import java.util.List;

import static camp.next.constant.BlackJackConst.DEALER_BOUND;
import static camp.next.constant.BlackJackConst.FIRST_DISTRIBUTION_TIME;

public class Game {
    public static final String DEALER_NAME = "딜러";
    public static final String DELIMITER = " - ";

    private final Distributor distributor;
    private final CalculateStrategy calculateStrategy;

    private final List<User> users = new ArrayList<>();
    private final User dealer;

    public Game(Distributor distributor, CalculateStrategy calculateStrategy) {
        this.distributor = distributor;
        this.calculateStrategy = calculateStrategy;
        this.dealer = new User(DEALER_NAME, calculateStrategy);
    }

    public void createUser(String[] userNames) {
        for (String userName : userNames) {
            users.add(new User(userName, calculateStrategy));
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

    public void init() {
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

    public String showUserNames() {
        StringBuilder sb = new StringBuilder();
        users.forEach((user) -> sb.append(user.getName()).append(", "));
        return sb.substring(0, sb.length() - 2);
    }

    public String showAllCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(dealer.showCards()).append('\n');
        users.forEach((user) ->
                sb.append(user.showCards()).append('\n'));
        return sb.toString();
    }

    public boolean requiresDealerDistributed() {
        return dealer.calculate() <= DEALER_BOUND;
    }

    public String showResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(dealer.showCards()).append(DELIMITER).append(dealer.getResult()).append('\n');
        users.forEach((user) ->
                sb.append(user.showCards()).append(DELIMITER).append(user.getResult()).append('\n'));
        return sb.toString();
    }

    public String showProfit() {
        StringBuilder sb = new StringBuilder();
        sb.append("## 최종 수익").append('\n');
        users.forEach((user) ->
                sb.append(user.getName())
                        .append(DELIMITER).append(user.getProfit(dealer.calculate())).append('\n'));
        return sb.toString();
    }
}
