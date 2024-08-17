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
    Image bgImg;

    public CombatPanel(CombatSession combatSession) {
        this.combatSession = combatSession;

        revalidate();
        setBackground(bgColor);
        setBounds(1050, 575, 500, 250);

        optionMenu();
    }

    public void optionMenu() {
        removeAll();

        setLayout(new GridLayout(2, 3, 5, 5));

        add(createButton(100, 100, 100, 100, new JButton("Attack")));
        add(createButton(200, 100, 100, 100, new JButton("Pokemon")));
        add(createButton(100, 200, 100, 100, new JButton("Inventory")));
        add(createButton(200, 200, 100, 100, new JButton("Run Away")));
    }

    public void attackMenu() {
        removeAll();

        setLayout(new GridLayout(4, 1, 5, 5));

        int index = 0;
        for ( Ability ability : combatSession.currentPlayer.abilityList ) {
            add(createButton(1, 1, 1, 1, new JButton(ability.name + " " + index)));
            index += 1;
        }

        currentMenu = "attackMenu";
        // repaint();
    }

    public void pokemonMenu() {
        removeAll();

        setLayout(new GridLayout(4, 1, 5, 5));

        int index = 0;
        for ( PokePal pokemon : combatSession.player1.pokePals) {
            System.out.println(pokemon.palName);
            add(createButton(1, 1, 1, 1, new JButton(pokemon.palName + " " + index)));
            index += 1;
        }

        currentMenu = "pokemonMenu";
    }

    public void inventoryMenu() {
        removeAll();

        setLayout(new GridLayout(4, 1, 5, 5));

        int index = 0;
        for ( String item : combatSession.player1.inventory) {
            add(createButton(1, 1, 1, 1, new JButton(item + " " + index)));
            index += 1;
        }

        currentMenu = "inventoryMenu";
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
            if (currentMenu == "optionMenu") {
                if(text == "Attack"){ 
                    currentMenu = "attackMenu";
                    attackMenu();
                }
                else if(text == "Pokemon"){ 
                    currentMenu = "pokemonMenu";
                    pokemonMenu();
                }
                else if (text == "Inventory"){ 
                    currentMenu = "inventoryMenu";
                    inventoryMenu();
                }
                else if (text == "Run Away"){ 
                    combatSession.SingleGameLoop(4, -1);
                }
            }
            else {
                int endingIndex = Integer.parseInt(text.substring(text.length() - 1, text.length()));
                optionMenu();
                if (currentMenu == "attackMenu") {
                    combatSession.SingleGameLoop(1, endingIndex);
                } else if (currentMenu == "pokemonMenu") {
                    combatSession.SingleGameLoop(2, endingIndex);
                } else if (currentMenu == "inventoryMenu") {
                    combatSession.SingleGameLoop(3, endingIndex);
                }
                currentMenu  = "optionMenu";
            }

            revalidate();
        }
    }
}
