package players;

import util.Input;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character{
    private String name;
    private HashMap<String, Integer> stats = new HashMap<>();
    private Input sc = new Input();

    public Player(){
        this.name = sc.getInput("Name Please");
        System.out.printf("Nice to meet you %s%n", this.getName());
        int health = sc.getNum("You can set your health", 0, 100);
        int attack = sc.getNum("You can set your attack", 0, 20);
        int defense = sc.getNum("You can set your defense", 0, 20);
        int agility = sc.getNum("You can set your agility", 0, 10);
        this.addStat("Health", health);
        this.addStat("Attack", attack);
        this.addStat("Defense", defense);
        this.addStat("Agility", agility);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
