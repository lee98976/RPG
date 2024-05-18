package module1;
import java.util.Scanner;

public class Main {
    
public static void reverseArray(int row[]){

    int middle = row.length/2;
    for(int i = 0; i<middle; i++)
    {
        int temp = row[i];
        row[i] = row[row.length-i-1];
        row[row.length-i-1]= temp;


    }


}

    public static int mystery(int n){
        if (n<0)
            return 2;
        else   
            return mystery(n-1);
    }
    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        int [][] numbers1= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

    
        for(int row=0; row < numbers1.length; row++){
            reverseArray(numbers1[row]);
        }


        System.out.println(mystery(3));
        /* 
        for(int row=0; row < numbers1.length; row++){
            for(int col =0; col < numbers1[0].length; col++){
                System.out.println(numbers1[row][col]);
            }    
        }
        */

    
    

        
                
       
            


        /* 
        System.out.println("Hello world!");
        Player player = new Player("Oscar", 5);

        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = scanner.nextInt();
            System.out.println("Type 1 to fight, 2 to defend, 3 to run away.");
            if (choice == 1){
                System.out.println("You dealt");

            }
            }
             */
            
    //         int[] ages = new int[50];
    //         for(int i=0; i<ages.length; i++)
    //         {
    //             ages[i] = ages.length-i;
            
    //         }
    //         for(int i=ages.length-1; i>-1; i--)
    //         {
    //             ages[i] = ages[i]*ages[i];
    //             System.out.println(ages[i]);

    //         }
        }
        
    }


