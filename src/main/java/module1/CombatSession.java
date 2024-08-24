package module1;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import module1.Abilities.Ability;
import module1.Scenes.CombatPanel;
import module1.UIElements.HealthBar;

public class CombatSession {
    public Random rand;
    public CombatPanel combatPanel;
    public Screen screen;
    public JTextArea battleLog;

    public Player player1;
    public PokePal currentPlayer;
    public HealthBar playerHealthBar;

    public Player aiPlayer;
    public PokePal currentEnemy;
    public HealthBar enemyHealthBar;

    public CombatSession(Player player1, Player aiPlayer, Screen screen) {
        this.player1 = player1;
        this.aiPlayer = aiPlayer;
        this.screen = screen;

        // Libraries
        rand = new Random();

        // Select pokemon
        SelectActivePokemon(0);
        currentEnemy = aiPlayer.pokePals.get(0);

        // Initialize UI
        combatPanel = new CombatPanel(this);
        playerHealthBar = new HealthBar(280, 300, 400, 50);
        enemyHealthBar = new HealthBar(850, 100, 400, 50);
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setFont(new Font("Georgia", Font.BOLD, 24));
        battleLog.getCaret().setDot( Integer.MAX_VALUE );
        JScrollPane scrollPanel = new JScrollPane(battleLog);


        updateHealthBar(playerHealthBar, currentPlayer);
        updateHealthBar(enemyHealthBar, currentEnemy);
        screen.betterAdd(combatPanel, 1050, 575, 500, 250); 
        screen.betterAdd(scrollPanel, 50, 575, 950, 250);
        screen.add(playerHealthBar);
        screen.add(enemyHealthBar);
    }

    public void updateHealthBar(HealthBar healthBar, PokePal pokemon) {
        healthBar.updateHealthBar(pokemon.health / pokemon.maxHp);
    }

    // public void betterSleep(int millis) {
    //     try {
    //         Thread.sleep(millis);
    //     } catch(InterruptedException e) {
    //         System.out.println(e);
    //     }
    // }

    public void SingleGameLoop(int choice, int choice2) {

        combatPanel.isActive = false;
        // Your turn: 
        turn(player1, false, choice, choice2);
        // Enemy turn:
        turn(aiPlayer, true, 0, 0);

        combatPanel.isActive = true;

        // Check if player has won or lost every loop
        
        // Ability enemyAbility = currentEnemy.getAbilityList().get(enemyChoiceInt);
    }

    public void SelectActivePokemon(int index) {
        PokePal selectedPokemon = player1.pokePals.get(index);
        if (selectedPokemon.health >= 0) {
            currentPlayer = selectedPokemon;
        } else {
            updateBattleLog(selectedPokemon.palName + ", pokepal number " + Integer.toString(index + 1) + ",  has already fainted!");
            SelectActivePokemon(index + 1);
        }
    }

    public void UseItem(Player player, int choice){
        String itemName = player.inventory.get(choice);
        if (itemName == "Potion") {currentPlayer.healPal(10);}
        else if (itemName == "Super Potion") {currentPlayer.healPal(20);}
        else if (itemName == "Full Heal Potion") {currentPlayer.healPal(currentPlayer.maxHp);}
    }

    public void updateBattleLog(String string) {
        battleLog.setText(battleLog.getText() + "\n" + string);
    }

    public void turn(Player player, boolean isAI, int choice, int choice2) {
        // Choice 2 is an extra parameter when you attack as you have to
        // choose an attack to use

        String playerName = player.name;
        PokePal pokePal;
        PokePal enemyPokePal;

        if (isAI) {
            pokePal = currentEnemy; 
            enemyPokePal = currentPlayer;

        } else {
            pokePal = currentPlayer; 
            enemyPokePal = currentEnemy;
        }

        String pokePalName = pokePal.palName;

        if (isAI) { 
            int[] weightedBounds = {0, 10, 12, 16, 16};
            choice = rand.nextInt(weightedBounds[weightedBounds.length - 1]);
            for (int i = 1; i < 5; i++) {
                if (choice >= weightedBounds[i-1] && choice < weightedBounds[i]){
                    choice = i;
                    break;
                }
            }
        }

        if (choice == 1){
            if (isAI) { choice2 = rand.nextInt(0, currentEnemy.abilityList.size()); }
            updateBattleLog(pokePalName + " attacked!"); 
            // updateBattleLog(choice2);
            attack(pokePal.abilityList.get(choice2), pokePal, enemyPokePal);
        } else if (choice == 2) {
            if (isAI) { choice2 = rand.nextInt(0, aiPlayer.pokePals.size()); }
            updateBattleLog(playerName + " is switching pokemon...");
            SelectActivePokemon(choice2);
        } else if (choice == 3) {
            if (player.inventory.size() != 0) {
                if (isAI) { choice2 = rand.nextInt(0, player.inventory.size()); }
            } else {
                updateBattleLog(playerName + " scoured his bag but could find nothing!");
            }
        } else if (choice == 4) {
            updateBattleLog(playerName + " ran away!"); 
        }

        // betterSleep(300);
        updateBattleLog("Turn over.");
    }

    // Create function for pokemon stats, function has access to important attributes (Damage, health, etc)
    public void attack(Ability abilityUsed, PokePal user, PokePal opponent){
        int damage = Math.round(abilityUsed.potency * user.attack - opponent.defense);
        if (damage < 0) {damage = 1;}

        // RNG determines critcal
        int critcalChance = rand.nextInt(0, 100);
        if (critcalChance < abilityUsed.critChance){damage = (int)(damage * 1.5);}

        // System.out.println("damage" + damage);
        boolean isDead = opponent.hurtPal(damage);

        // System.out.println(currentEnemy.health);
        
        // System.out.println(currentEnemy.maxHp);

        playerHealthBar.updateHealthBar(Math.clamp((float) currentPlayer.health / (float) currentPlayer.maxHp, 0, 1));
        enemyHealthBar.updateHealthBar(Math.clamp((float) currentEnemy.health / (float) currentEnemy.maxHp, 0, 1));

        if (isDead) {
            // TODO
        }
    }
}
