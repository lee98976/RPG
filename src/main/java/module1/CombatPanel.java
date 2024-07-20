package module1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CombatPanel extends JPanel implements ActionListener{
    Color bgColor = new Color(0, 0, 0);
    JButton attackButton = new JButton();
    JButton pokemonButton = new JButton();
    JButton inventoryButton = new JButton();
    JButton runButton = new JButton();
    // BufferedImage bgImage = ImageIO.read(new File("module1\\Backgrounds\\Forest.png"));

    public CombatPanel() {
        setBackground(bgColor);
        setLayout(null);
        setVisible(true);
        battleScene();
    }

    //Scenes://
        //BattleScene://
    public void battleScene(){
        attackButton = attackButton(100, 100, 100, 100, attackButton);
        pokemonButton = attackButton(100, 100, 100, 100, pokemonButton);
        inventoryButton = attackButton(100, 100, 100, 100, pokemonButton);
        runButton = attackButton(100, 100, 100, 100, pokemonButton);

        add(attackButton);
        add(pokemonButton);
        add(inventoryButton);
        add(runButton);
    }

    public JButton attackButton(int xPos, int yPos, int width, int height, JButton button1) {
        button1.setBounds(xPos, yPos, width, height);
        button1.addActionListener(this);
        button1.setVisible(true);
        return button1;
    }

    public JButton pokemonButton(int xPos, int yPos, int width, int height, JButton button1) {
        button1.setBounds(xPos, yPos, width, height);
        button1.addActionListener(this);
        button1.setVisible(true);
        return button1;
    }

    
    @Override                                                                                                                                          
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == attackButton){
            System.out.println("bro attacked");
        } else if(e.getSource() == pokemonButton) {
            System.out.println("bro attacked his own pokemon");
        } else if (e.getSource() == inventoryButton) {
            System.out.println("bro inventory");
        } else if (e.getSource() == runButton) {
            System.out.println("bro ran");
        }
    }
}
