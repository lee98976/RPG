package module1;

import java.util.ArrayList;
import java.util.Scanner;

import module1.Abilities.AttackAbility;
import module1.Perks.Perk;
import module1.Perks.PerkTree;

public class Player {
    public String name;
    public ArrayList<PokePal> pokePals;
    public ArrayList<String> inventory;
    private PerkTree perkTree;
    private int trainerLevel;

    // Load data
    public Player(PerkTree perkTree) {
        this.perkTree = perkTree;
    }

    // New character
    public Player(String name) throws InterruptedException {
        this.name = name;
        pokePals = new ArrayList<PokePal>();
        inventory = new ArrayList<String>();
        perkTree = new PerkTree(new Perk(0, "Health Boost", true));
        trainerLevel = 1;
    }

    // Preset Pals Init
    public void addPresetPal(String palName) {
        PokePal selectedPokemon;
        if (palName == "Pikachu") {
            selectedPokemon = new PokePal("Pikachu", 1, 30, 2, 1, 0, 1, 1, 1, 1);
            selectedPokemon.abilityList.add(new AttackAbility(0, 20, 2, "Electric", "Thunderbolt"));
        } else if (palName == "Ghastly") {
            selectedPokemon = new PokePal("Ghastly", 1, 20, 3, 1, 0, 1, 1, 1, 1);
            selectedPokemon.abilityList.add(new AttackAbility(0, 10, 1.5f, "Gas", "Smoke Screen"));
        } else {
            selectedPokemon = new PokePal("404", 1, 1, 1, 1, 1, 1, 1, 1, 1);
        }
        pokePals.add(selectedPokemon);
    }
}
