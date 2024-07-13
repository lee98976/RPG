package module1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Screen extends JFrame implements ActionListener{
    //References://
   // DialogueHandler text = new DialogueHandler();

    //Settings://
    int width = 1600;
    int height = 900;
    Color bgColor = new Color(172, 165, 201);
    Font dialogueFont = new Font("Helvetica", Font.BOLD, 100);

    //Scenes://

    //TestScene://
    JButton testButton = new JButton();

    public Screen() {
        setSize(width, height);
        setTitle("RPG");
        getContentPane().setBackground(bgColor);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CombatPanel Panel = new CombatPanel();
        
        add(Panel);
        add(new JPanel(), BorderLayout.SOUTH);
        add(new JButton("dam"), BorderLayout.NORTH);
        add(new JButton("dam"), BorderLayout.EAST);
        add(new JButton("dam"), BorderLayout.WEST);
        setVisible(true);
    }

    public void initButton(int xPos, int yPos, int width, int height, JButton button1) {
        button1.setBounds(xPos, yPos, width, height);
        // button1.setVerticalAlignment(JButton.CENTER);
        // button1.setHorizontalAlignment(JButton.CENTER);
        button1.addActionListener(this);
        button1.setVisible(true);
        add(button1); 
    }

    public void testScene() throws InterruptedException{
    //     initButton(100, 100, 100, 100, testButton);
    //     DialogueText testText = new DialogueText(text.getDialogue("intro.txt"), dialogueFont);
    //     testText.fancyText("HELLO BYE HELLO BYE", this);
    }

    @Override                                                                                                                                          
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == testButton){
            System.out.println("hi");
        }
    }
}
