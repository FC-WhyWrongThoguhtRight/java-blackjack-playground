package nextstep.blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cards {
    List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
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
