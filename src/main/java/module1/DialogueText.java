package module1;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class DialogueText extends JLabel{
    List<String> dialogue;

    public DialogueText(List<String> dialogue){
        this.dialogue = dialogue;
    }

    public void fancyText(String text) throws InterruptedException{
        String line = "";
        for(char c : text.toCharArray()){
            line += c;
            System.out.println(line);
            setText(line);
            Thread.sleep(50);
        }
    }

    public void dialogue(String name) throws InterruptedException{ //Testing
        for(String text : dialogue){
            fancyText(text);
            Thread.sleep(1000);
        }
    }
}
