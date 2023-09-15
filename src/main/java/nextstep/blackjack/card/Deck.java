package nextstep.blackjack.card;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import nextstep.blackjack.code.CardNumber;
import nextstep.blackjack.code.CardShape;

/**
 * 트럼프 카드 52장
 */
public class Deck {
    private final Queue<Card> deck;

    private Deck(final Queue<Card> cards) {
        this.deck = cards;
    }

    public static Deck createDeck(ShuffleStrategy shuffleStrategy) {
        List<CardNumber> cardNumbers = CardNumber.getAll();
        List<CardShape> cardShapes = CardShape.getAll();
        List<Card> cards = makeCardList(cardNumbers, cardShapes);

        return new Deck(new LinkedList<>(shuffleStrategy.shuffle(cards)));
    }

    public Card draw() {
        return deck.poll();
    }

    private static List<Card> makeCardList(List<CardNumber> cardNumbers, List<CardShape> cardShapes) {
        return cardShapes.stream().flatMap(shape -> cardNumbers.stream()
                .map(number -> new Card(shape, number)))
                .collect(Collectors.toList());
    }
}
