package blackjack.person;

import blackjack.card.Deck;

public interface Person {

    void batting();

    void hit(Deck deck);

    String getName();

    void moreDraw(Deck deck);

    Integer sum();

    boolean isBust();

    void win(Person dealer);

    Integer loseMoney(Integer money);

    Integer getMoney();
}
