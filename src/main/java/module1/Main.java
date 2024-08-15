package module1;

import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Screen screen = new Screen();

                    Player player = new Player("Ash");
                    player.pokePals.add(new PokePal("Pikachu", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                    Player enemy = new Player("Team Rocket");
                    enemy.pokePals.add(new PokePal("Rocket", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                    screen.battleScene(player, enemy, "GrassBattlefield");

                    
                    
                    
                } catch (InterruptedException e) {
                }
                // DialogueText label = new DialogueText(text.getDialogue("intro.txt"));
                // label.setHorizontalTextPosition(JLabel.CENTER);
                // label.setHorizontalAlignment(JLabel.CENTER);
                // label.setFont();
                // label.fancyText("sdifhsdbionerwiofruebioqetu
            }
        });
    }
}