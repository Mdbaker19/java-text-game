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
        int fights = 1;
        you.viewStats(you);
        if(battle(you, fights)) fights++;
        System.out.printf("You have won %d fights%n", fights - 1);
    }

    public static boolean battle(Player you, int fightNumber){
        Art art = new Art();
        Input sc = new Input();
        Enemy enemy = new Enemy(fightNumber);
        boolean win = false;

        do{
            art.hud(you);
            String turn = sc.getInput("Your move");
            if (turn.equalsIgnoreCase("i")) {
                art.viewInventory(you);
            } else if(turn.equalsIgnoreCase("a")){
                int yourDamage = you.attack();
                System.out.println("You deal " +yourDamage+" damage");
                enemy.setHealth(enemy.getHealth() - yourDamage);
            }

            int enemyDmg = enemy.attack();
            System.out.println("Enemy deals " +enemyDmg+" damage");
            you.setHealth(you.getHealth() - enemyDmg);

            System.out.printf("%-50s Enemy Health: %d%n", " ", enemy.getHealth());

        }while(you.getHealth() > 0 && enemy.getHealth() > 0);

        if(you.getHealth() > 0){
            System.out.println("You have won the fight");
            win = true;
        } else {
            System.out.println("Looks like you lost");
        }

        return win;
    }

}
