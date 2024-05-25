package module1;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Text text = new Text();
        int width = 1600;
        int height = 900;
        //Player player = new Player("Oscar");
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setTitle("RPG");
        frame.setVisible(true);
        
        Color bgColor = new Color(172, 165, 201);
        frame.getContentPane().setBackground(bgColor);
        JLabel label = new JLabel();
        label.setText("oscar");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 1000));
        frame.add(label);
        
        
        
    }  
}


