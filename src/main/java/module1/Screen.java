package module1;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import module1.Scenes.CombatPanel;
import module1.UIElements.Panel;

public class Screen extends JFrame implements ActionListener{
    //References://
    DialogueHandler text = new DialogueHandler();

    //Settings://
    int width = 1600;
    int height = 900;
    int currentScene = 0;
    Color bgColor = new Color(172, 165, 255);

    Image bgImg;
    Font dialogueFont = new Font("Helvetica", Font.BOLD, 100);

    public Screen() {
        setSize(width, height);
        setTitle("RPG");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void betterAdd(Component component, int x, int y, int width, int height){
        component.setBounds(x, y, width, height);
        component.repaint();
        component.revalidate();
        add(component);
    }
    
    public void battleScene(Player player1, Player aiPlayer, String backgroundName) throws InterruptedException {
        setBackground(backgroundName);
        CombatSession combatSession = new CombatSession(player1, aiPlayer, this);
    }

    public void dialogueScene(String sceneName) throws InterruptedException {
        setBackground(sceneName);
        DialogueSession dialogueSession = new DialogueSession(sceneName, this);
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
        if (bgName == "GrassBattlefield") {bgImg = getFile("RPG/assets/backgrounds/meadow.png"); } 
        else if (bgName == "Beginning") {bgImg = getFile("RPG/assets/backgrounds/thebeginning.png"); }
        bgImg = bgImg.getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        setContentPane(new Panel(bgImg));
    }

    public void gameScenesSequence(){ 
        try {
            currentScene = 1; //TODO
            if (currentScene == 0) {
                dialogueScene("Beginning");
            } else if (currentScene == 1) {
                Player player = new Player("Ash");
                player.addPresetPal("Pikachu");
                Player enemy = new Player("Team Rocket");
                enemy.addPresetPal("Ghastly");
                        
                battleScene(player, enemy, "GrassBattlefield"); 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        currentScene += 1;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                