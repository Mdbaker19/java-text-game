package util;

import players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input (){
        this.sc = new Scanner(System.in);
    }

    public String getInput(){
        return this.sc.next();
    }

    public String getInput(String message){
        System.out.println(message);
        return this.sc.next();
    }

    public String getInput(String message, String option1, String option2, String option3){
        System.out.println(message);
        String input = this.sc.next();
        if(!input.equalsIgnoreCase(option1) && !input.equalsIgnoreCase(option2) && !input.equalsIgnoreCase(option3)){
            return getInput("Please choose from one of the 3 options", option1, option2, option3);
        }
        return input;
    }

    public String getAction(String message){
        System.out.println(message);
        String choice = this.sc.next();
        if(!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("i")){
            return getAction("Please choose either A for attack or I for inventory");
        }
        return choice;
    }

    public int getNum(){
        return this.sc.nextInt();
    }

    public String getInventoryChoice(String message, Player player){
        System.out.println(message);
        HashMap<String, Integer> options = player.getInventory();
        String input = this.sc.next();
        if(input.equalsIgnoreCase("e")){
            return input;
        }
        if(options.get(input) == null){
            return getInventoryChoice("You do not have that item", player);
        } else if (options.get(input) < 1){
            return getInventoryChoice("You are out of those items", player);
        }
        return input;
    }


    public int getNum(String message){
        System.out.println(message);
        String input = this.getInput();
        try{
            int num = Integer.parseInt(input);
            return num;
        } catch (Exception ignored){
            return getNum("Not a valid input");
        }
    }

    public int getNum(String message, int min, int max){
        System.out.println(message+" between "+min+" and "+max);
        String input = this.getInput();
        try{
            int num = Integer.parseInt(input);
            if(num > max || num < min){
                return getNum("Invalid range", min, max);
            }
            return num;
        } catch (Exception ignored){
            return getNum("Not a valid input", min, max);
        }
    }

    public double decimal(){
        return this.sc.nextDouble();
    }

}
