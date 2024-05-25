package module1;
import java.util.Scanner;

public class Battle {
    private Scanner scanner = new Scanner(System.in);

    public void BattleTurn(){
        while(true){
            int choice = scanner.nextInt();
            System.out.println("Type 1 to fight, 2 to defend, 3 to run away.");
            if (choice == 1){
                System.out.println("You dealt");

            }
        }
    }
}
