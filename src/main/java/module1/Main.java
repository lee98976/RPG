package module1;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DialogueHandler text = new DialogueHandler();
        int width = 1600;
        int height = 900;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setTitle("RPG");
        frame.setVisible(true);
        
        Color bgColor = new Color(172, 165, 201);
        frame.getContentPane().setBackground(bgColor);
  
        DialogueText label = new DialogueText(text.getDialogue("intro.txt"));
        label.fancyText("ewriweurwrweru");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 100));
        frame.add(label);

        
        Player player = new Player("Jeff");
    }  
}


