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




    public static void startGame(Player you) throws InterruptedException {
        Input sc = new Input();
        int fights = 1;
        you.viewStats(you);
        do {
            if (battle(you, fights)) {
                fights++;
                System.out.println("Gained 50xp");
                you.gainXP(50);
                you.setLevel();
                System.out.println("Curr exp: " +you.getExp());
                System.out.println("Curr level: " + you.getLevel());
                you.viewStats(you);
            } else {
                System.out.println("Looks like you lost");
            }
            System.out.printf("You have won %d fights, %d more to fight the boss%n", fights - 1, 6 - fights);
            if(!sc.getInput("Would you like to fight again and keep training? [Y]es / [N]o").equalsIgnoreCase("y")) {
                break;
            }
        } while (true);

        if(fights >= 5){
            System.out.println("somethings coming...");
//            bossFight();
        }
    }

    public static boolean battle(Player you, int fightNumber) throws InterruptedException {
        Art art = new Art();
        Input sc = new Input();
        Enemy enemy = new Enemy(fightNumber);
        boolean win = false;

        double enemyDefenseMultiplier =  Math.floor( 100 - enemy.getStats().get("Defense")) / 100;
        double playerDefenseMultiplier = Math.floor( 100 - you.getStats().get("Defense")) / 100;

        do{
            art.hud(you);
            you.statusCheck();
            you.viewStats(you);
            String turn = sc.getAction("Your move");
            do {

                if (turn.equalsIgnoreCase("i")) {

                        if (!art.viewInventory(you)) {
                            turn = sc.getAction("Your move");
                            // ======= NEED TO BE IN A LOOP HERE
                        }

                }

            } while(!turn.equalsIgnoreCase("a"));
            if(turn.equalsIgnoreCase("a")){
                int yourDamage = (int) (you.attack() * enemyDefenseMultiplier);
                if(enemy.blockChance()){
                    System.out.println("You missed");
                    Thread.sleep(300);
                    yourDamage = 0;
                } else {
                    if(you.critChance()){
                        System.out.println("Critical Hit");
                        Thread.sleep(300);
                        yourDamage*=2;
                    }
                    System.out.println("You deal " + yourDamage + " damage");
                }
                enemy.setHealth(enemy.getHealth() - yourDamage);
                if(enemy.getHealth() <= 0) {
                    System.out.println("You have won the fight");
                    win = true;
                    break;
                }
            }
            Thread.sleep(500);

            int enemyDmg = (int) (enemy.attack() - playerDefenseMultiplier);
            if(you.blockChance()){
                System.out.println("You dodged the attack");
                enemyDmg = 0;
            } else {
                if(enemy.poisonAttack()){
                    you.setStatus("poison");
                    System.out.println("Enemy poisons you");
                    Thread.sleep(300);
                }
                System.out.println("Enemy deals " + enemyDmg + " damage");
            }
            you.setHealth(you.getHealth() - enemyDmg);

            System.out.printf("%-50s Enemy Health: %d%n", " ", enemy.getHealth());

        }while(you.getHealth() > 0 && enemy.getHealth() > 0);

        return win;
    }

}
