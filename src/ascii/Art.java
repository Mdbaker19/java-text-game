package ascii;

import players.Player;
import util.Input;

import java.util.HashMap;
import java.util.Map;

public class Art {

    public Art(){}

    public void playerNormal(){
        System.out.println();
        System.out.println();
        System.out.printf("%-10s        \\\\\\|||///%n", " ");
        System.out.printf("%-10s      .  =======%n", " ");
        System.out.printf("%-10s     / \\| O   O |%n", " ");
        System.out.printf("%-10s     \\ / \\`___'/%n", " ");
        System.out.printf("%-8s        #   _| |_%n", " ");
        System.out.printf("%-8s       (#) (     )%n", " ");
        System.out.printf("%-8s        #\\//|* *|\\\\%n", " ");
        System.out.printf("%-8s        #\\/(  *  )/%n", " ");
        System.out.printf("%-8s        #   =====%n", " ");
        System.out.printf("%-8s        #   ( U )%n", " ");
        System.out.printf("%-8s        #   || ||%n", " ");
        System.out.printf("%-8s       .#___'| |`____.%n", " ");
        System.out.printf("%-8s       `#----' `-----'%n", " ");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void enemyAnimal() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.printf("%-10s                   .\"`\".%n", " ");
        System.out.printf("%-10s               .-./ _=_ \\.-.%n", " ");
        System.out.printf("%-10s              {  (,(oYo),) }}%n", " ");
        System.out.printf("%-10s              {{ |   \"   |} }%n", " ");
        System.out.printf("%-10s              { { \\(---)/  }}%n", " ");
        System.out.printf("%-10s              {{  }'-=-'{ } }%n", " ");
        System.out.printf("%-10s              { { }._:_.{  }}%n", " ");
        System.out.printf("%-10s              {{  } -:- { } }%n", " ");
        System.out.printf("%-10s              {_{ }`===`{  _}%n", " ");
        System.out.printf("%-10s             ((((\\)     (/))))%n", " ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void enemyInsect(){
        System.out.printf("%-10s                   ,--.       ,---.%n", " ");
        System.out.printf("%-10s                   /    '.    /     \\%n", " ");
        System.out.printf("%-10s                         \\  ;%n", " ");
        System.out.printf("%-10s                          \\-|%n", " ");
        System.out.printf("%-10s                          (ø ø)      (/%n", " ");
        System.out.printf("%-10s                          /ˆˆˆ     ,-'%n", " ");
        System.out.printf("%-10s                  ,------/ >< \\---'%n", " ");
        System.out.printf("%-10s                 /)     ;  --  :%n", " ");
        System.out.printf("%-10s                    ,---| ---- |--.%n", " ");
        System.out.printf("%-10s                   ;    | ---- |   :%n", " ");
        System.out.printf("%-10s                  (|  ,-| ---- |-. |)%n", " ");
        System.out.printf("%-10s                     | /| ---- |\\ |%n", " ");
        System.out.printf("%-10s                     |/ | ---- | \\|%n", " ");
        System.out.printf("%-10s                     \\  : ---- ;  |%n", " ");
        System.out.printf("%-10s                      \\  \\ -- /  /%n", " ");
        System.out.printf("%-10s                      ;   \\  /  :%n", " ");
        System.out.printf("%-10s                     /   / \\/ \\  \\%n", " ");
        System.out.printf("%-10s                    /)           (\\%n", " ");
    }

    public static void main(String[] args) {
        Art a = new Art();
        a.enemyInsect();
    }

    public void welcome(){
        for(int i = 0; i < 4; i++){
            System.out.printf("%-5s|%-219s-|%n", " ", "-");
        }
        System.out.printf("%-5s|%-105s %s %-106s|%n"," ", " ", "Welcome", " ");
        for(int i = 0; i < 4; i++){
            System.out.printf("%-5s|%-219s-|%n", " ", "-");
        }
    }
    public void info(){
        System.out.printf("%-86s%-25s%-25s%-25s%n", " ", "[A]bout", "[O]ptions", "[S]tart");
    }

    public void hud(Player player){
        int health = player.getStats().get("Health");
        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");
        System.out.printf("|%-30sHealth: %d%n", " ", health);
        System.out.printf("|%-29s[I]nventory%n", " ");
        System.out.printf("|%-29s[A]ttack%n", " ");
        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");
    }

    public boolean viewInventory(Player player){
        boolean usedItem = false;
        Input sc = new Input();
        HashMap<String, Integer> inv = player.getInventory();
        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");
        System.out.printf("|%-30s%n", "[E]xit");
        for(Map.Entry<String, Integer> item : inv.entrySet()){
            System.out.printf("|%-30s%s: %d%n"," ", item.getKey(), item.getValue());
        }

        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");
        String choice = sc.getInventoryChoice("What would you like to use?", player);

        if(choice.equalsIgnoreCase("potion")){
            System.out.println("Using Potion, Healed by 45");
            player.setHealth(player.getHealth() + 45);
            player.useItem("Potion");
            usedItem = true;
        } else if(choice.equalsIgnoreCase("antidote")){
            if(player.getStatus().equals("poison")) {
                System.out.println("Using Antidote");
                System.out.println("healing poison");
                player.setStatus("Normal");
                player.useItem("Antidote");
                usedItem = true;
            } else {
                System.out.println("You do not need this item");
            }
        } else if(choice.equalsIgnoreCase("critical")){
            System.out.println("Using Critical");
            player.useItem("Critical");
            player.setStatus("Critical");
            usedItem = true;
        } else if(choice.equalsIgnoreCase("e")){
            return false;
        }
        return usedItem;
    }

}
