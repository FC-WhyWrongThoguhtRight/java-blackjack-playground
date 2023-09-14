package blackjack.model.person;

import java.util.ArrayList;
import java.util.List;

public class Players {

    List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String s) {
        String[] names = s.split(",");

        List<Player> persons = new ArrayList<>();
        for (String name : names) {
            persons.add(new Player(name));
        }
        return new Players(persons);
    }



}
