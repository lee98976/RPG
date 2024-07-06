package module1;

import java.util.ArrayList;
import java.util.Random;
import module1.Abilities.Ability;

public class PokePal {
    //Statistics
    private String palName;
    private int level;
    private int exp;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int maxHp;
    private int currentHp;

    //Individual Values
    private int healthIV;
    private int attackIV;
    private int defenseIV;
    private int speedIV;

    //Stat Inclinations
    private int healthInc;
    private int attackInc;
    private int defenseInc;
    private int speedInc;

    private ArrayList<Ability> abilityList;
    private Random rand;

    public PokePal(String palName, int level, int health, int attack, int defense, int speed, int hInc, int aInc, int dInc, int sInc, int maxHp) {
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
            defenseIV += rand.nextInt(defenseInc / 2, defenseInc * 3 / 2);
            speedIV += rand.nextInt(speedInc / 2, speedInc * 3 / 2);
            health = maxHp;
        }
    }

    public String getPalName() {
        return palName;
    }

    public void setPalName(String palName) {
        this.palName = palName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public ArrayList<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(ArrayList<Ability> abilityList) {
        this.abilityList = abilityList;
    }

}
