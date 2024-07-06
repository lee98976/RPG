package module1;
import java.util.ArrayList;
import java.util.Random;
import module1.Abilities.Ability;

public class CombatSession {
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
            System.out.println("Pokemon is fainted!");
        }
    }

    public void SingleTurn(Ability ability){
        int enemyChoiceInt = rand.nextInt(0, currentEnemy.getAbilityList().size());
        Ability enemyAbility = currentEnemy.getAbilityList().get(enemyChoiceInt);

        
    }
}
