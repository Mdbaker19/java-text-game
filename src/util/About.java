package util;

public class About {
    public About(){}

    public void viewOptions(){
        System.out.println("Options here");
    }
    public void viewAbout() throws InterruptedException {
        System.out.println("A text battle game, you start with 2 potions to heal, 1 critical hit juice and 1 antidote");
        System.out.println("Enemy has a 10% chance to poison, using critical doubles your critical chance, 2x damage for 3 turns");
        System.out.println("Boss fight is available after winning 5 standard fights");
        System.out.println("Enemy gets stronger everytime you win a battle");
        Thread.sleep(800);
    }

}
