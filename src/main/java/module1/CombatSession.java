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

    public void PlayerTurn(){
        int choice = scanner.nextInt();
        System.out.println("Type 1 to fight, 2 to defend, 3 to run away.");
        if (choice == 1){ 
            System.out.println("You attacked!"); 
        } else if (choice == 2) {
            System.out.println("You ");
        }else if (choice==3) {

        }

    }

    public void SingleTurn(Ability ability){
        // Your enemy
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
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
