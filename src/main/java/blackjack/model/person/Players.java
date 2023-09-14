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


    public String getNames() {
        StringBuilder sb = new StringBuilder();
        for(Player player : players){
            sb.append(player.getName()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public List<Player> getList(){
        return players;
    }


    public void bat() {
        for(Player player : players){
            player.bat();
        }
    }
}
