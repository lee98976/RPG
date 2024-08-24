package module1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import module1.CombatSession;
import module1.DialogueHandler;
import module1.DialogueText;
import module1.PokePal;
import module1.Abilities.Ability;
import module1.Scenes.DialogueButtonPanel;

public class DialogueSession{
    public Screen screen;

    // Dialogue
    public DialogueHandler dialogueHandler;
    public List<String> dialogueText;
    public int currentDialogue;

    // UI
    public DialogueButtonPanel buttonPanel;
    public ImageIcon characterImage;
    public JLabel picture;
    public JPanel dialogueBox;
    public JButton nextButton;
    public DialogueText currentText;
    

    public DialogueSession(String sceneName, Screen screen) {
        this.screen = screen;

        dialogueHandler = new DialogueHandler();
        currentDialogue = 0;

        if (sceneName == "Beginning") {
            try {
                BufferedImage image = ImageIO.read(new File("RPG/assets/ash.png"));
                Image image2 = image.getScaledInstance(450, 450, Image.SCALE_DEFAULT);
                characterImage = new ImageIcon(image2);
            } catch (Exception e) {System.out.println(e);}
            dialogueText = dialogueHandler.getDialogue("thebeginning.txt");
        }

        currentText = new DialogueText();
        currentText.setBounds(250, 600, 1100, 100);
        screen.add(currentText);

        buttonPanel = new DialogueButtonPanel(this);
        buttonPanel.setBounds(1300, 750, 100, 50);
        buttonPanel.setBackground(new Color(230, 230, 230));
        screen.add(buttonPanel);

        dialogueBox = new JPanel();
        dialogueBox.setBounds(200, 600, 1200, 200);
        dialogueBox.setBackground(new Color(230, 230, 230));

        picture = new JLabel();
        picture.setIcon(characterImage);
        Dimension size = picture.getPreferredSize();
        picture.setBounds(200, 300, size.width, size.height);

        screen.add(dialogueBox);
        screen.add(picture);

    }

    public void next() {
        if (currentDialogue >= dialogueText.size()) {
            System.out.println("Dialogue has finished.");
            screen.getContentPane().removeAll();
            screen.repaint();
            screen.gameScenesSequence();
            return;
        }

        currentText.fancyText(dialogueText.get(currentDialogue), screen);

        currentDialogue += 1;
        // if (currentDialogue >= dialogueText.size()) {
        //     System.out.println("Dialogue has finished.");
        // }
    }
}
