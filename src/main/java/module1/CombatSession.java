package module1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import module1.Abilities.Ability;

public class CombatSession {
    Random rand;
    CombatPanel combatPanel;

    Player player1;
    PokePal currentPlayer;
    int playerChoice;

    Player aiPlayer;
    PokePal currentEnemy;

    public CombatSession(Player player1, Player aiPlayer, Screen screen) {
        this.player1 = player1;
        this.aiPlayer = aiPlayer;

        playerChoice = -1;
        combatPanel = new CombatPanel(this);
        rand = new Random();

        screen.add(combatPanel);
        
        // Select pokemon
        SelectActivePokemon(0);
        System.out.println(aiPlayer.pokePals.get(0).palName);
        currentEnemy = aiPlayer.pokePals.get(0);

        // Setup UI
        
    }

    public void betterSleep(int millis) {
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

    public void SingleGameLoop(int choice) {

        combatPanel.isActive = false;
        // Your turn: 
        turn(player1, false, choice);
        betterSleep(3000);
        // Enemy turn
        turn(aiPlayer, true, 0);

        combatPanel.isActive = true;

        // Check if player has won or lost every loop
        
        // Ability enemyAbility = currentEnemy.getAbilityList().get(enemyChoiceInt);
    }

    public void SelectActivePokemon(int index) {
        PokePal selectedPokemon = player1.pokePals.get(index);
        if (selectedPokemon.health >= 0) {
            currentPlayer = selectedPokemon;
        } else {
            System.out.println(selectedPokemon.palName + ", pokepal number " + Integer.toString(index + 1) + ",  has already fainted!");
            SelectActivePokemon(index + 1);
        }
    }

    public void UseItem(Player player, int choice){
        String itemName = player.inventory.get(choice);
        if (itemName == "Potion") {currentPlayer.healPal(10);}
        else if (itemName == "Super Potion") {currentPlayer.healPal(20);}
        else if (itemName == "Full Heal Potion") {currentPlayer.healPal(currentPlayer.maxHp);}
    }

    public void turn(Player player, boolean isAI, int choice) {
        String playerName = player.name;
        PokePal pokePal;
        if (isAI) {pokePal = currentEnemy; }
        else {pokePal = currentPlayer; }
        String pokePalName = pokePal.palName;

        // Use GUI to get player input TODO
        if (isAI) { choice = rand.nextInt(1, 4); }
        else {
            choice = playerChoice;
        }

        if (choice == 1){ 
            System.out.println(pokePalName + " attacked!"); 
        } else if (choice == 2) {
            System.out.println(playerName + " is switching pokemon...");
        } else if (choice == 3) {
            if (player.inventory.size() != 0) {
                String itemText = "Type the corresponding number for the item: ";
                int index = 1;
                for (String item : player.inventory) {
                    itemText += item + " - " + index + ", ";
                    index += 1;
                }
                itemText = itemText.substring(0, player.inventory.size()-2);
                itemText += ".";
                System.out.println(itemText);

                if (isAI) { choice = rand.nextInt(0, player.inventory.size() - 1); }
                // else { choice = }

                // TODO
                // choice = scanner.nextInt();
                // UseItem(player, choice);
            } else {
                System.out.println(playerName + " scoured his bag but could find nothing!");
            }
        } else if (choice == 4) {
            System.out.println(playerName + " ran away!"); 
        }

        playerChoice = -1;
        betterSleep(300);
        System.out.println("Turn over.");
    }

    // Create function for pokemon stats, function has access to important attributes (Damage, health, etc)
    public void calculateDamage(Ability abilityUsed, PokePal user, PokePal opponent){
        int damage = abilityUsed.potency + user.attack - opponent.defense;
        int critcalChance = rand.nextInt(0, 100);
        if (critcalChance < abilityUsed.critChance){damage = (int)(damage * 1.5);}
        boolean isDead = opponent.hurtPal(damage);
        if (isDead) {}
    }
}
