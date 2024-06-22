package module1;
import javax.swing.*;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

public class DialogueText extends JLabel{
    List<String> dialogue;
    JFrame frame;

    public DialogueText(List<String> dialogue, Font font){
        this.dialogue = dialogue;
    }

    public void fancyText(String text, JFrame frame) throws InterruptedException{
        String line = "";
        frame.add(this);      
        for(char c : text.toCharArray()){
            line += c;
            System.out.println(line);
            setText(line);
            Thread.sleep(50);
        }

        Thread.sleep(1000);

        frame.remove(this);
        frame.revalidate();
        frame.repaint();
    }

    public void dialogue(String name, JFrame frame) throws InterruptedException{ //Testing
        for(String text : dialogue){
            //fancyText(text);
            Thread.sleep(1000);
        }
    }
}
