package module1;

public class Entity {
    protected String name;
    protected int level;
    protected int health;
    protected int defense;
    protected int dexterity;
    protected int attack;
    protected int maxHp;

    //Health increases health and reduces status apply rate
    //Defense increases damage taken by set amount and reduces status apply rate
    //Dexterity decreases damage taken by a set percentage and increases speed
    //Attack increases attack and status apply rate

    public Entity(String name, int level, int health, int defense, int dexterity, int attack){
        this.name = name;
        this.level = level;
        this.health = health;
        this.defense = defense;
        this.dexterity = dexterity;
        this.attack = attack;
        this.maxHp = health;
    }

    public Entity(String name){
        initialize();
    }

    protected void initialize(){
        level = 1;
        health = 10;
        maxHp = 10;
        defense = 0;
        dexterity = 0;
        attack = 0;
    }
}
