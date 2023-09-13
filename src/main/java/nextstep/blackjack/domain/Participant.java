package nextstep.blackjack.domain;

public class Participant {
    private Cards cards;

    public Participant() {
        this.cards = new Cards();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        return cards.getBestScore();
    }
}
