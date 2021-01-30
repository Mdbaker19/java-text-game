package players;

import java.util.Map;

public class Character {

    public void viewStats(Player player) {
        System.out.println("Stats => ");
        for(Map.Entry<String, Integer> v : player.getStats().entrySet()){
            System.out.println(v.getKey() + " : " + v.getValue());
        }
    }

    public int attack(Player player){
        int currAttack = player.getStats().get("Attack");
        int dmg = 0;

        return dmg;
    }

    public double blockChance(Player player){
        int currAgil = player.getStats().get("Agility");
        double chanceToBlock = 1;


        return chanceToBlock;
    }

}
