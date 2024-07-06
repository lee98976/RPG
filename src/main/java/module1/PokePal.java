package module1;

import java.util.ArrayList;

import module1.Abilities.Ability;

public class PokePal {
    private String palName;
    private int level;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int maxHp;
    private int currentHp;

    private ArrayList<Ability> abilityList;

    public PokePal(String palName, int level, int health, int attack, int defense, int speed, int maxHp) {
        this.palName = palName;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHp = maxHp;
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
