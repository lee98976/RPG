package module1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CombatPanel extends JPanel implements ActionListener{
    CombatSession combatSession;

    Color bgColor = new Color(10, 150, 10);
    JButton attackButton = new JButton("Attack");
    JButton pokemonButton = new JButton("Change Pokemon");
    JButton inventoryButton = new JButton("Inventory");
    JButton runButton = new JButton("Run Away");
    Image bgImg;

    public CombatPanel(CombatSession combatSession) {
        this.combatSession = combatSession;

        setVisible(true);

        setBackground(bgColor);
        setLayout(new GridLayout(2, 2, 5, 5));
        setBounds(1050, 575, 500, 250);

        attackButton = createButton(100, 100, 100, 100, attackButton);
        pokemonButton = createButton(200, 100, 100, 100, pokemonButton);
        inventoryButton = createButton(100, 200, 100, 100, inventoryButton);
        runButton = createButton(200, 200, 100, 100, runButton);

        add(attackButton);
        add(pokemonButton);
        add(inventoryButton);
        add(runButton);
    }

    public JButton createButton(int xPos, int yPos, int width, int height, JButton button1) {
        button1.setBounds(xPos, yPos, width, height);
        button1.addActionListener(this);
        button1.setVisible(true);
        return button1;
    }
    
    @Override                                                                                                                                          
    public void actionPerformed(ActionEvent e) {
        int choice;
        if(e.getSource() == attackButton){ choice = 1; }
        else if(e.getSource() == pokemonButton){ choice = 2; }
        else if (e.getSource() == inventoryButton){ choice = 3; }
        else if (e.getSource() == runButton){ choice = 4; }
        else { choice = -1; }
        combatSession.playerChoice = choice;
    }
}
