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
        perkTree = new PerkTree(new Perk(0, "Health Boost", true));
        // text.dialogue("intro.txt");
    }
}
