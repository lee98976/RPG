package module1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import module1.Abilities.Ability;

public class CombatSession {
    Scanner scanner;
    Player player1;
    ArrayList<PokePal> enemyPokes;
    PokePal currentPlayer;
    PokePal currentEnemy;
    Random rand;

    public CombatSession(Player player1, ArrayList<PokePal> enemyPokes) {
        this.player1 = player1;
        this.enemyPokes = enemyPokes;
    }

    public void SelectActivePokemon(PokePal selectedPokemon) {
        if (selectedPokemon.getHealth() >= 0) {
            currentPlayer = selectedPokemon;
        } else {
            System.out.println("Pokemon has fainted!");
        }
    }

    public void UseItem(int choice){
        String itemName = player1.inventory.get(choice);
        if (itemName == "Potion") {currentPlayer.healPal(10);}
        else if (itemName == "Super Potion") {currentPlayer.healPal(20);}
        else if (itemName == "Full Heal Potion") {currentPlayer.healPal(currentPlayer.getHealth());}
    }

    public void PlayerTurn(){
        System.out.println("Type 1 to fight, 2 to defend, 3, to use an item, and 4 to run away.");
        int choice = scanner.nextInt();

        if (choice == 1){ 
            System.out.println("You attacked!"); 
        } else if (choice == 2) {
            System.out.println("You are attempting to block...");
        } else if (choice == 3) {
            String itemText = "Type the corresponding number for the item: ";
            int index = 1;

            if (player1.inventory.size() != 0) {
                for (String item : player1.inventory) {
                    itemText += item + " - " + index + ", ";
                    index += 1;
                }
                itemText = itemText.substring(0, player1.inventory.size()-2);
                itemText += ".";
                System.out.println(itemText);

                choice = scanner.nextInt();
                UseItem(choice);
            } else {
                System.out.println("You have no items!");
                PlayerTurn();
            }
            
        }
    }

    public void SingleTurn(Ability ability){
        // Your turn
        PlayerTurn();

        // Enemy turn
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
