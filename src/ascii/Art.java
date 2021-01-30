package ascii;

import players.Player;
import util.Input;

import java.util.HashMap;
import java.util.Map;

public class Art {

    public Art(){}

    public void playerNormal(){
        System.out.printf("%-10s {˙˙˙˙˙˙˙}%n", " ");
        System.out.printf("%-10s {      o|%n", " ");
        System.out.printf("%-10s ^^^|  |^^%n", " ");
        System.out.printf("%-10s  __[  ]__%n", " ");
        System.out.printf("%-7s___{        }___%n", " ");
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

    public void viewInventory(Player player){
        Input sc = new Input();
        HashMap<String, Integer> inv = player.getInventory();
        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");

        for(Map.Entry<String, Integer> item : inv.entrySet()){
            System.out.printf("|%-30s%s: %d%n"," ", item.getKey(), item.getValue());
        }

        System.out.print("|");
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("|");
        String choice = sc.getInput("What would you like to use?");

        if(choice.equalsIgnoreCase("potion")){
            System.out.println("using Potion");
        } else if(choice.equalsIgnoreCase("antidote")){
            System.out.println("using Antidote");
        } else if(choice.equalsIgnoreCase("critical")){
            System.out.println("using Critical");
        }

    }

}
