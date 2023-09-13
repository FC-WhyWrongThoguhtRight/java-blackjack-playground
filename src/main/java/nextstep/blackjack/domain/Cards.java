package nextstep.blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cards {
    List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int getBestScore() {
        return Arrays.stream(getScores()).filter(score -> score <= 21).max().orElse(22);
    }

    public int[] getScores() {
        Set<Integer> possibleScores = new HashSet<>();
        calcPossibleScores(cards, 0, 0, possibleScores);
        return possibleScores.stream().mapToInt(i -> i).sorted().toArray();
    }

    private static void calcPossibleScores(List<Card> cards, int index, int currentScore, Set<Integer> possibleScores) {
        if (index == cards.size()) {
            possibleScores.add(currentScore);
            return;
        }

        int[] cardScores = cards.get(index).getScores();
        for (int cardScore : cardScores) {
            calcPossibleScores(cards, index + 1, currentScore + cardScore, possibleScores);
        }
    }
}
