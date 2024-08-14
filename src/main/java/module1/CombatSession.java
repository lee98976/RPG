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
        combatPanel = new CombatPanel(this);
        screen.add(combatPanel);
    }

    public void SelectActivePokemon(PokePal selectedPokemon) {
        if (selectedPokemon.getHealth() >= 0) {
            currentPlayer = selectedPokemon;
        } else {
            System.out.println("Pokemon has fainted!");
        }
    }

    public void UseItem(Player player, int choice){
        String itemName = player.inventory.get(choice);
        if (itemName == "Potion") {currentPlayer.healPal(10);}
        else if (itemName == "Super Potion") {currentPlayer.healPal(20);}
        else if (itemName == "Full Heal Potion") {currentPlayer.healPal(currentPlayer.getHealth());}
    }

    public void turn(Player player, boolean isAI){
        String playerName = player.name;
        PokePal pokePal = currentPlayer;
        String pokePalName = pokePal.getPalName();

        // Use GUI to get player input TODO
        int choice;
        if (isAI) { choice = rand.nextInt(1, currentEnemy.getAbilityList().size()); }
        else {
            while (playerChoice == -1) { ; }
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
        System.out.println("Turn over.");
    }

    public void SingleTurn(Ability ability){
        // Your turn
        turn(player1, false);

        // Enemy turn
        turn(aiPlayer, true);
        
        int enemyChoiceInt = rand.nextInt(0, currentEnemy.getAbilityList().size());
        Ability enemyAbility = currentEnemy.getAbilityList().get(enemyChoiceInt);

        // Find which move is faster

    }

    // Create function for pokemon stats, function has access to important attributes (Damage, health, etc)
    public void calculateDamage(Ability abilityUsed, PokePal user, PokePal opponent){
        int damage = abilityUsed.getPotency() + user.getAttack() - opponent.getDefense();
        int critcalChance = rand.nextInt(0, 100);
        if (critcalChance < abilityUsed.getCritChance()){damage = (int)(damage * 1.5);}
        boolean isDead = opponent.hurtPal(damage);
        if (isDead) {}
    }
}
