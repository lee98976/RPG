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

                    Player player = new Player("Ash");
                    PokePal pikachu = new PokePal("Pikachu", 1, 10, 3, 2, 0, 1, 1, 1, 1);
                    pikachu.abilityList.add(new AttackAbility(0, 0, 0, "Electric", "Thunderbolt"));
                    player.pokePals.add(pikachu);
                    Player enemy = new Player("Team Rocket");
                    enemy.pokePals.add(new PokePal("Ghastly", 1, 5, 5, 3, 0, 1, 1, 1, 1));
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