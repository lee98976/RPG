package module1;

import java.util.ArrayList;
import java.util.Random;
import module1.Abilities.Ability;

public class PokePal {
    //Statistics
    public String palName;
    public int level;
    public int exp;
    public int health;
    public int attack;
    public int defense;
    public int speed;
    public int maxHp;
    public int currentHp;

    //Individual Values
    public int healthIV;
    public int attackIV;
    public int defenseIV;
    public int speedIV;

    //Stat Inclinations
    public int healthInc;
    public int attackInc;
    public int defenseInc;
    public int speedInc;

    public ArrayList<Ability> abilityList;
    public Random rand;

    public PokePal(String palName, int level, int health, int attack, int defense, int speed, int hInc, int aInc, int dInc, int sInc, int maxHp) {
        rand = new Random();
        this.palName = palName;

        this.healthIV = rand.nextInt(1, 32);
        this.attackIV = rand.nextInt(1, 32);
        this.defenseIV = rand.nextInt(1, 32);
        this.speedIV = rand.nextInt(1, 32);

        this.level = level;
        
        this.health = health + healthIV;
        this.attack = attack + attackIV;
        this.defense = defense + defenseIV;
        this.speed = speed + speedIV;
        this.maxHp = maxHp;

        this.healthInc = hInc;
        this.attackInc = aInc;
        this.defenseInc = dInc;
        this.speedInc = sInc;
    }

    public void checkLevel() {
        while (exp >= 50 * Math.pow(1.1, this.level)) {
            exp -= 50 * Math.pow(1.1, this.level);
            level += 1;
            maxHp += rand.nextInt(healthInc / 2, healthInc * 3 / 2);
            attack += rand.nextInt(attackInc / 2, attackInc * 3 / 2);
            defense += rand.nextInt(defenseInc / 2, defenseInc * 3 / 2);
            speed += rand.nextInt(speedInc / 2, speedInc * 3 / 2);
            health = maxHp;
        }
    }

    public void healPal(int amount){
        health += amount;
        if (health > maxHp){
            health = maxHp;
        }
    }

    public boolean hurtPal(int amount){
        amount = Math.min(amount-defense, 1);
        health -= amount;
        if (health < 0) {return true;}
        else {return false;}
    }
}
