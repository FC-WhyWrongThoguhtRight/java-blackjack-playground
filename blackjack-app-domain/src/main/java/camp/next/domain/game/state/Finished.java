package camp.next.domain.game.state;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

public abstract class Finished extends Started {
    protected Finished(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        throw new RuntimeException("이미 끝난 게임입니다.");
    }

    @Override
    public State stay() {
        throw new RuntimeException("이미 끝난 게임입니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double batAmount) {
        return batAmount * earningRate();
    }

    public abstract double earningRate();
}
