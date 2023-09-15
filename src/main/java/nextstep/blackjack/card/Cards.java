package nextstep.blackjack.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cards {
    private final List<Card> cards;
    private Cards() {
        this.cards = new ArrayList<>();
    }

    public static Cards createCards(){
        return new Cards();
    }

    public int getCardNumberTotal(){
        return cards.stream().map(Card::getNumber).reduce(0, (i, j) -> i + j);
    }

    public void addCard(final Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        String str = "";
        for(Card card : cards){
            str += card.toString() + ",";
        }

        return str.substring(0, str.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cards cards1 = (Cards) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
