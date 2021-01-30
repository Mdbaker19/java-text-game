package players;

import java.util.HashMap;
import java.util.Map;

public class Enemy extends Character{

    private HashMap<String, Integer> stats = new HashMap<>();


    public Enemy(int number){
        int health = 15 * number;
        int attack = 3 * number;
        int defense = 3 * number;
        int agility = 2 * number;
        this.addStat("Health", health);
        this.addStat("Attack", attack);
        this.addStat("Defense", defense);
        this.addStat("Agility", agility);
    }



    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }
    public void addStat(String type, int value){
        this.stats.put(type, value);
    }


}
