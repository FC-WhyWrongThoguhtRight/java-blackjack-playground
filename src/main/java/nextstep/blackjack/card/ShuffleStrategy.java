package nextstep.blackjack.card;

import java.util.List;
import nextstep.blackjack.card.Card;

public interface ShuffleStrategy {
    List<Card> shuffle(List<Card> cards);
}
