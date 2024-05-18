package module1;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Player player = new Player("Oscar", 5);

        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = scanner.nextInt();
            System.out.println("Type 1 to fight, 2 to defend, 3 to run away.");
            if (choice == 1){
                System.out.println("You dealt");

            }
        }

    
    }  
}


