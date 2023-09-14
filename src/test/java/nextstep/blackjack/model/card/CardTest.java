package nextstep.blackjack.model.card;

import java.util.List;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void testCard() {
        Card card1 = new Card(Symbol.ACE, Type.DIAMOND);
        Card card2 = new Card(Symbol.ACE,Type.DIAMOND);
        Card card3 = new Card(Symbol.TWO,Type.CLUB);
        Card card4 = new Card(Symbol.THREE,Type.CLUB);

        System.out.println("card1 == card2 => " + card1.equals(card2));
        System.out.println("card3 == card4 => " + card3.equals(card4));
        System.out.println("card1 : " + card1);
        System.out.println("card2 : " + card2);
        System.out.println();
    }

    @Test
    void cardFactoryTest() {
        List<Card> cards = CardFactory.create();

        int index = 0;
        for(Card card : cards){
            System.out.println("["+index+"]" + card.toString());
            index++;
        }
    }
}