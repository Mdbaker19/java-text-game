import ascii.Art;
import players.Enemy;
import players.Player;
import util.About;
import util.Input;

import java.util.Map;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Art art = new Art();
        Input sc = new Input();
        About aboutGame = new About();

        do {
            art.welcome();
            art.info();
            String option = sc.getInput();
            if (option.equalsIgnoreCase("s")) {
                break;
            } else if (option.equalsIgnoreCase("a")) {
                aboutGame.viewAbout();
            } else if (option.equalsIgnoreCase("o")) {
                aboutGame.viewOptions();
            }
        } while(true);
            Player you = new Player();
            startGame(you);
    }




    public static void startGame(Player you){
        int fights = 0;
        you.viewStats(you);
        if(battle(you, fights)) fights++;
    }

    public static boolean battle(Player you, int fightNumber){
        Enemy enemy = new Enemy(fightNumber);
        boolean win = false;

        do{

        }while(you.getStats().get("Health") > 0 || enemy.getStats().get("Health") > 0);//healths > 0;

        return win;
    }

}
