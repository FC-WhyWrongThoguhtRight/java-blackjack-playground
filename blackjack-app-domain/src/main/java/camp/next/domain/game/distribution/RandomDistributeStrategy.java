package camp.next.domain.game.distribution;

import camp.next.domain.card.Card;
import camp.next.domain.card.Denomination;
import camp.next.domain.card.Suit;

import java.util.Random;

public class RandomDistributeStrategy implements DistributeStrategy {
    @Override
    public Card distribute() {
        Random random = new Random();
        int denOrd = random.nextInt(Denomination.values().length);
        int suitOrd = random.nextInt(Suit.values().length);
        Denomination denomination = Denomination.getDenomination(denOrd);
        Suit suit = Suit.getSuit(suitOrd);
        return new Card(denomination, suit);
    }
}
