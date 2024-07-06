package module1;

import java.util.ArrayList;
import java.util.Scanner;

import module1.Perks.Perk;
import module1.Perks.PerkTree;

public class Player {

    private ArrayList<PokePal> pokePals;
    private PerkTree perkTree;
    private int trainerLevel;
    // private DialogueHandler text = new DialogueHandler();
    // Load data

    public Player(PerkTree perkTree) {
        this.perkTree = perkTree;
    }

    // New character
    public Player(String name) throws InterruptedException {
        perkTree = new PerkTree(new Perk(0, "Health Boost"));
        // text.dialogue("intro.txt");
    }

    public void checkLevel() {
        /*
         * while (exp >= 50 * Math.pow(1.1, this.level)) {
         * exp -= 50 * Math.pow(1.1, this.level);
         * level += 1;
         * health = 1;
         * // TODO add level up problems
         * 
         * }
         */
    }

}
