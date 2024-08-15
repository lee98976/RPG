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

import module1.Abilities.Ability;

public class CombatPanel extends JPanel implements ActionListener{
    CombatSession combatSession;
    boolean isActive = true;
    String currentMenu = "optionMenu";

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
        setBounds(1050, 575, 500, 250);

        optionMenu();
    }

    public void optionMenu() {
        removeAll();

        setLayout(new GridLayout(2, 2, 5, 5));
        attackButton = createButton(100, 100, 100, 100, attackButton);
        pokemonButton = createButton(200, 100, 100, 100, pokemonButton);
        inventoryButton = createButton(100, 200, 100, 100, inventoryButton);
        runButton = createButton(200, 200, 100, 100, runButton);

        add(attackButton);
        add(pokemonButton);
        add(inventoryButton);
        add(runButton);

        currentMenu = "optionMenu";
    }

    public void attackMenu() {
        removeAll();

        setLayout(new GridLayout(4, 1, 5, 5));

        int index = 0;
        for ( Ability ability : combatSession.currentPlayer.abilityList ) {
            index += 1;
            add(createButton(1, 1, 1, 1, new JButton(ability.name + " " + index)));
        }

        currentMenu = "attackMenu";
    }

    public JButton createButton(int xPos, int yPos, int width, int height, JButton button1) {
        button1.setBounds(xPos, yPos, width, height);
        button1.addActionListener(this);
        button1.setVisible(true);
        return button1;
    }
    
    @Override                                                                                                                                          
    public void actionPerformed(ActionEvent e){
        if (isActive) {
            JButton button = (JButton) e.getSource();
            String text = button.getText();
            
            int choice;
            if(text == "Attack"){ choice = 1; }
            else if(text == "Change Pokemon"){ choice = 2; }
            else if (text == "Inventory"){ choice = 3; }
            else if (text == "Run Away"){ choice = 4; }
            else { choice = -1; }
            combatSession.playerChoice = choice;

            combatSession.SingleGameLoop(choice);
        }
    }
}
