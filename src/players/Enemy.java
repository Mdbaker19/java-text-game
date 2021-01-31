package players;

import java.util.HashMap;
import java.util.Map;

public class Enemy {

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

    public int getHealth(){
        return this.getStats().get("Health");
    }
    public void setHealth(int newHealth){
        this.getStats().put("Health", newHealth);
    }

    public int attack(){
        return this.getStats().get("Attack");
    }

    public boolean blockChance(){
        int ran = (int) Math.floor(Math.random() * 100);
        int currAgil = this.getStats().get("Agility");
        return (currAgil * 1.25) > ran;
    }

    public boolean poisonAttack(){
        int ran = (int) Math.floor(Math.random() * 100);
        return ran < 10;
    }


    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void addStat(String type, int value){
        this.stats.put(type, value);
    }


}
