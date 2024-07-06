package module1.Abilities;

public class AttackAbility extends Ability {

    public AttackAbility(int accuracy, float critChance, int potency, String element) {
        this.accuracy = accuracy;
        this.critChance = critChance;
        this.potency = potency;
        this.element = element;

        // protected StatusEffect effect;
        // protected int statusAccuracy;
    }

}
