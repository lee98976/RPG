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
                    //TODO Design actual pokepals

                    Player player = new Player("Ash");
                    PokePal pikachu = new PokePal("Pikachu", 1, 100, 3, 2, 0, 1, 1, 1, 1);
                    pikachu.abilityList.add(new AttackAbility(0, 50, 2, "Electric", "Thunderbolt"));
                    player.pokePals.add(pikachu);

                    Player enemy = new Player("Team Rocket");
                    PokePal ghastly = new PokePal("Ghastly", 1, 50, 5, 3, 0, 1, 1, 1, 1);
                    ghastly.abilityList.add(new AttackAbility(0, 50, 1.5f, "Fart", "Smoke Screen"));
                    enemy.pokePals.add(ghastly);
                    


                    screen.battleScene(player, enemy, "GrassBattlefield"); 
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
    }
}