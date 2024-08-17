package module1;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import module1.CombatPanel;
import module1.Panel;

import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Screen extends JFrame implements ActionListener{
    //References://
    DialogueHandler text = new DialogueHandler();

    //Settings://
    int width = 1600;
    int height = 900;
    Color bgColor = new Color(172, 165, 255);

    Image bgImg;
    Font dialogueFont = new Font("Helvetica", Font.BOLD, 100);

    public Screen() throws InterruptedException {
        setSize(width, height);
        setTitle("RPG");
        setVisible(true);
        // getContentPane().setBackground(bgColor);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void battleScene(Player player1, Player aiPlayer, String battlefieldName) throws InterruptedException {
        setBackground(battlefieldName);
        CombatSession combatSession = new CombatSession(player1, aiPlayer, this);
    }

    public Image getFile(String filePath) {
        try {
            File f = new File(filePath);
            Image image = ImageIO.read(f);
            return image;
        } catch(IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public void setBackground(String bgName) {
        if (bgName == "GrassBattlefield") {
            bgImg = getFile("RPG/assets/bg.png");
            bgImg = bgImg.getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
            setContentPane(new Panel(bgImg));
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
    

    // DialogueText testText = new DialogueText(text.getDialogue("intro.txt"), dialogueFont);
    // testText.fancyText("HELLO BYE HELLO BYE", this);
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                