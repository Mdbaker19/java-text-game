package util;

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
