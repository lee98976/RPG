package module1;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class DialogueText extends JLabel{
    String line = "";
    int currentCharIndex = 0;
    Timer animTimer = new Timer(0, null);

    public DialogueText(){
        setFont(new Font("Georgia", Font.PLAIN, 24));
        setText("");
    }

    public void updateText(String text, JFrame frame){
        line += text.toCharArray()[currentCharIndex];
        currentCharIndex += 1;
        setText(line);

        frame.repaint();
        frame.revalidate();

        if (currentCharIndex >= text.toCharArray().length) {
            animTimer.stop();
        }
    }

    public void fancyText(String text, JFrame frame) {
        animTimer.stop();

        line = "";
        currentCharIndex = 0;

        animTimer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                updateText(text, frame);
            }
        });
        
        animTimer.start();
    } 
}
