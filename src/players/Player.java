package players;

import util.Input;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character{
    private String name;
    private HashMap<String, Integer> stats = new HashMap<>();
    private HashMap<String, Integer> inventory = new HashMap<>();
    private Input sc = new Input();
    private String status = "Normal";
    private int level;
    public int exp;
    public int statusTurnCounter = 0;

    public Player(){
        this.level = 1;
        int health;
        int attack;
        int defense;
        int agility;
        int critical;
        this.name = sc.getInput("Name Please");
        String path = sc.getInput("What class would you like to pick? [P]aladin, [T]hief, [N]othing Special", "p", "t", "n");

        if(path.equalsIgnoreCase("p")){
            health = 125;
            attack = 12;
            defense = 15;
            agility = 6;
            critical = 15;
            System.out.printf("Nice to meet you Paladin %s%n", this.getName());
            System.out.println("You have extra health, defense and attack at the cost of agility");
        } else if(path.equalsIgnoreCase("t")){
            health = 85;
            attack = 12;
            defense = 8;
            agility = 18;
            critical = 30;
            System.out.printf("Nice to meet you Thief %s%n", this.getName());
            System.out.println("You have extra agility, critical chance and attack at the cost of health and defense");
        } else {
            health = 100;
            attack = 10;
            defense = 10;
            agility = 10;
            critical = 15;
            System.out.printf("Nice to meet you Human %s%n", this.getName());
            System.out.println("You are nothing special....");
        }

        this.addStat("Health", health);
        this.addStat("Attack", attack);
        this.addStat("Defense", defense);
        this.addStat("Agility", agility);
        this.addStat("Critical", critical);
        this.addItem("Potion", 2);
        this.addItem("Critical", 1);
        this.addItem("Antidote", 1);
    }

    public int getLevel(){
        return this.level;
    }
    public int getExp(){
        return this.exp;
    }

    public void setLevel() throws InterruptedException {
        if(this.exp >= 100){
            this.level += 1;
            this.exp-=100;
            Thread.sleep(500);
            System.out.println("You leveled up!");
            Thread.sleep(500);
            increaseStatsFromLevelUp();
        }
    }
    private void increaseStatsFromLevelUp(){

        HashMap<String, Integer> currStats = this.getStats();
        HashMap<String, Integer> leveledStats = new HashMap<>();
        for(Map.Entry<String, Integer> stat : currStats.entrySet()){
            leveledStats.put(stat.getKey(), stat.getValue() + 5); // probably come back to this for a better calculation
        }
        this.setStats(leveledStats);
    }
    public void gainXP(int exp){
        this.exp += exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }
    public void addStat(String type, int value){
        this.stats.put(type, value);
    }

    public HashMap<String, Integer> getInventory(){
        return this.inventory;
    }

    public void addItem(String type, int quantity){
        if(this.inventory.get(type) != null){
            this.inventory.put(type, this.inventory.get(type) + 1);
        } else {
            this.inventory.put(type, quantity);
        }
    }
    public void useItem(String type){
        this.inventory.put(type, this.inventory.get(type) - 1);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void statusCheck() throws InterruptedException {
        String currStatus = this.getStatus();
        if(currStatus.equalsIgnoreCase("normal")){
            return;
        }
        if(this.statusTurnCounter >= 3){
            System.out.println("Critical Wears Off");
            Thread.sleep(800);
            this.setStatus("Normal");
            this.statusTurnCounter = 0;
        }
        System.out.println("Current status is: " + currStatus);
        if (currStatus.equalsIgnoreCase("poison")) {
            System.out.println("You take 5 damage from poison");
            this.setHealth(this.getHealth() - 5);
        } else if (currStatus.equalsIgnoreCase("critical")){
            this.statusTurnCounter++;
            HashMap<String, Integer> currStats = this.getStats();
            if(!currStatus.equalsIgnoreCase("usingCritical")) {
                currStats.put("Critical", currStats.get("Critical") * 2);
                this.status = "usingCritical";
            }
            this.stats = currStats;
        }
    }

    public boolean critChance(){
        int ran = (int) Math.floor(Math.random() * 100);
        int currCrit = this.getStats().get("Critical");
        return currCrit > ran;
    }
}
