package module1.Scenes;

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
import module1.DialogueSession;
import module1.DialogueText;
import module1.PokePal;
import module1.Abilities.Ability;

public class DialogueButtonPanel extends JPanel implements ActionListener {
    JButton nextButton;
    DialogueSession dialogueSession;
    
    public DialogueButtonPanel(DialogueSession dialogueSession) {
        this.dialogueSession = dialogueSession;

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setVisible(true);
        add(nextButton);
    }

    @Override                                                                                                                                          
    public void actionPerformed(ActionEvent e){
        dialogueSession.next();
    }
}
