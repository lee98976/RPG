package module1.Abilities;

import module1.PokePal;

public abstract class Ability {
    public int accuracy;
    public int potency;
    public float critChance;
    public String element;
    public String name;
    
    

    // protected StatusEffect effect;
    // protected int statusAccuracy;

    public void doAction(PokePal user) {
    }

    public void doAction(PokePal user, PokePal target) {
    }

    public void doAction(PokePal user, PokePal[] targets) {
    }

}
