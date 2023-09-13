package blackjack.person;

import blackjack.card.Deck;
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

    public void batting() {

        for (Player person : players) {
            person.batting();
        }

    }

    public void firstDraw(Deck deck) {

        for (Player person : players){
            person.hit(deck);
            person.hit(deck);
        }
    }


    public String getNames() {
        StringBuilder sb = new StringBuilder();
        for(Player person : players){
            sb.append(person.getName()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public List<Player> getList(){
        return players;
    }

    public void moreDraw(Deck deck) {
        for(Player player : players){
            player.moreDraw(deck);
        }
    }

    public void end(Dealer dealer) {

    }


}
