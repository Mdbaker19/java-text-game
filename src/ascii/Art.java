package ascii;

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

    public  void info(){
        System.out.printf("%-86s%-25s%-25s%-25s%n", " ", "[A]bout", "[O]ptions", "[S]tart");
    }

}
