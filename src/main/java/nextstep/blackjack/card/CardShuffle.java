package nextstep.blackjack.card;

import java.util.Collections;
import java.util.List;

public class CardShuffle implements ShuffleStrategy {

    @Override
    public List<Card> shuffle(List<Card> cards) {
        Collections.shuffle(cards);
        return List.copyOf(cards);
    }
}
