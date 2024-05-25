package module1;
import javax.swing.*;

public class Text extends JLabel{
    public void displayText(String text){
        //Display text on the frame
    }

    public void fancyText(String text) throws InterruptedException{
        for(char c : text.toCharArray()){
            System.out.print(c);
            Thread.sleep(50);
        }
        System.out.println();
    }

    public void dialogue(String[] dialogue) throws InterruptedException{
        for(String text : dialogue){
            fancyText(text);
            System.out.println();
            Thread.sleep(1000);
        }
    }
}
