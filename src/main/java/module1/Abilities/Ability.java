package module1.Abilities;

import module1.PokePal;

public abstract class Ability {
    protected int accuracy;
    protected int potency;
    protected float critChance;
    protected String element;

    // protected StatusEffect effect;
    // protected int statusAccuracy;


    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public float getCritChance() {
        return critChance;
    }

    public void setCritChance(float critChance) {
        this.critChance = critChance;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void doAction(PokePal user) {
    }

    public void doAction(PokePal user, PokePal target) {
    }

    public void doAction(PokePal user, PokePal[] targets) {
    }

}
