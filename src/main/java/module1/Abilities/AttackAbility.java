package module1.Abilities;

public class AttackAbility extends Ability {

    public AttackAbility(int accuracy, float critChance, float potency, String element, String name) {
        this.accuracy = accuracy;
        this.critChance = critChance;
        this.potency = potency;
        this.element = element;
        this.name = name;
    }
}
