package players;

import java.util.Map;

public class Character {

    public void viewStats(Player player) {
        System.out.println("Stats => ");
        for(Map.Entry<String, Integer> v : player.getStats().entrySet()){
            System.out.println(v.getKey() + " : " + v.getValue());
        }
    }
}
