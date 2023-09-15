package nextstep.blackjack.gamer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gamers {
    private final List<Gamer> gamers;

    private Gamers(List<GamerDTO> gamers) {
        this.gamers = mapGamer(gamers);
    }

    public static Gamers createGames(List<GamerDTO> gamers){
        return new Gamers(gamers);
    }

    public Gamer getWinner() {
        return gamers.stream()
            .filter(i -> i.getTotal() > 0)
            .min(Comparator.comparingInt(Gamer::getTotal))
            .get();
    }

    public List<Gamer> getPlayers() {
        return List.copyOf(gamers);
    }

    public List<Gamer> judgeBlackjack() {
        List<Gamer> answers = new ArrayList<>();

        for (Gamer gamer : gamers) {
            if (gamer.isBlackjack()) {
                answers.add(gamer);
            }
        }

        return answers;
    }

    private List<Gamer> mapGamer(List<GamerDTO> gamers) {
        List<Gamer> answers = new ArrayList<>();

        for (GamerDTO gamerDTO : gamers) {
            answers.add(
                new Gamer(gamerDTO.getName(),gamerDTO.getBettingAmount(),gamerDTO.getClassification()));
        }

        return answers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Gamer gamer : gamers){
            stringBuilder.append(gamer.toString() + "\n");
        }

        return stringBuilder.toString();
    }
}
