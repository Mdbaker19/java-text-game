import ascii.Art;
import players.Player;
import util.Input;

import java.util.Map;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Art art = new Art();
        Input sc = new Input();

        do {
            art.welcome();
            art.info();
            String option = sc.getInput();
            if (option.equalsIgnoreCase("s")) {
                break;
            } else if (option.equalsIgnoreCase("a")) {
                viewAbout();
            } else if (option.equalsIgnoreCase("o")) {
                viewOptions();
            }
        } while(true);
            Player you = new Player();
            startGame(you);

    }
    public static void viewAbout(){
        System.out.println("About game");
    }
    public static void viewOptions(){
        System.out.println("Options here");
    }
    public static void startGame(Player you){
        System.out.println("Run the game");
        System.out.println("Stats => ");
        for(Map.Entry<String, Integer> v : you.getStats().entrySet()){
            System.out.println(v.getKey() + " : " + v.getValue());
        }
    }
}
