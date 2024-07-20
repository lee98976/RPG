package module1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Screen extends JFrame implements ActionListener{
    //References://
    DialogueHandler text = new DialogueHandler();

    //Settings://
    int width = 1600;
    int height = 900;
    Color bgColor = new Color(172, 165, 201);
    Font dialogueFont = new Font("Helvetica", Font.BOLD, 100);

    

    public Screen() throws InterruptedException {
        setSize(width, height);
        setTitle("RPG");
        setVisible(true);
        getContentPane().setBackground(bgColor);
        setLayout(null);
        battleScene();
    }

    

    // DialogueText testText = new DialogueText(text.getDialogue("intro.txt"), dialogueFont);
    // testText.fancyText("HELLO BYE HELLO BYE", this);
}
