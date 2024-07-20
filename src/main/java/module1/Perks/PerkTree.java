package module1.Perks;

public class PerkTree {
    private Perk root;
    private int[] currentStatBoosts; // Health, Defense, Dexterity, Attack

    // Health increases health and reduces status apply rate
    // Defense increases damage taken by set amount and reduces status apply rate
    // Dexterity decreases damage taken by a set percentage and increases speed
    // Attack increases attack and status apply rate

    public PerkTree(Perk startingPerk) {
        root = startingPerk;
        currentStatBoosts = new int[3];
        CreateTree();
    }

    private void CreateTree() {
        // Layer 1: Input: root
        Perk healthBoost1 = new Perk(10, "Health Boost", false);
        Perk defenseBoost1 = new Perk(2, "Defence Boost", false);
        Perk dexerityBoost1 = new Perk(1, "Dexterity Boost", false);
        Perk attackBoost1 = new Perk(3, "Attack Boost", false);
        healthBoost1.parent = root;
        defenseBoost1.parent = root;
        dexerityBoost1.parent = root;
        defenseBoost1.parent = root;
        root.children.add(healthBoost1);
        root.children.add(defenseBoost1);
        root.children.add(dexerityBoost1);
        root.children.add(attackBoost1);

        // Layer 2: Input: healthBoost1, defenseBoost1,
        // Skill HealSkill = new module1.Skills.HealSkill(0)
        // root.children.add(healthBoost2);
        // root.children.add(defenseBoost2);
        // root.children.add(dexerityBoost2);
        // root.children.add(attackBoost2);
    }

    public void checkStatBoosts(Perk skill) {
        for (Perk node : skill.children) {
            if (node.owned) {
                if (node.type.equals("Health Boost")) {
                    currentStatBoosts[0] += node.value;
                } else if (node.type.equals("Defence Boost")) {
                    currentStatBoosts[1] += node.value;
                } else if (node.type.equals("Dexterity Boost")) {
                    currentStatBoosts[2] += node.value;
                } else if (node.type.equals("Attack Boost")) {
                    currentStatBoosts[3] += node.value;
                }
            }
        
            checkStatBoosts(node);
        }
    }
}
