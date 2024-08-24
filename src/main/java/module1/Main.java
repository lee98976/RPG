package module1;

import java.util.Scanner;
import javax.swing.*;

import module1.Abilities.Ability;
import module1.Abilities.AttackAbility;

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

                    // Games sequence is run to advance the game scene
                    screen.gameScenesSequence();

                    // screen.dialogueScene("Beginning");

                    // Player player = new Player("Ash");
                    // player.addPresetPal("Pikachu");
                    // Player enemy = new Player("Team Rocket");
                    // enemy.addPresetPal("Ghastly");
                    
                    // screen.battleScene(player, enemy, "GrassBattlefield"); 

                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
 
}