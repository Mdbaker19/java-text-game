package players;

import java.util.Map;

public class Character {


    // THIS REALLY ONLY APPLIES TO PLAYER RIGHT NOW WITH PLAYER OBJ
    public void viewStats(Player player) {
        for(Map.Entry<String, Integer> v : player.getStats().entrySet()){
            System.out.print(v.getKey() + " : " + v.getValue()+"    ---     ");
        }
        System.out.println();
    }
}
