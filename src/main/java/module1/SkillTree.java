package module1;
import java.util.TreeSet;
import module1.Skills.Skill;
import module1.Skills.StatBuffSkill;

public class SkillTree {
    private Skill root;
    private int[] currentStatBoosts; //Health, Defense, Dexterity, Attack

    //Health increases health and reduces status apply rate
    //Defense increases damage taken by set amount and reduces status apply rate
    //Dexterity decreases damage taken by a set percentage and increases speed
    //Attack increases attack and status apply rate

    public SkillTree(Skill startingSkill){
        root = startingSkill;
        currentStatBoosts = new int[3];
        CreateTree();
    }

    private void CreateTree(){
        //Layer 1: Input: root
        Skill healthBoost1 = new StatBuffSkill(10, "Health Boost");
        Skill defenseBoost1 = new StatBuffSkill(2, "Defence Boost");
        Skill dexerityBoost1 = new StatBuffSkill(1, "Dexterity Boost");
        Skill attackBoost1 = new StatBuffSkill(3, "Attack Boost");
        healthBoost1.parent = root;
        defenseBoost1.parent = root;
        dexerityBoost1.parent = root;
        defenseBoost1.parent = root;
        root.children.add(healthBoost1);
        root.children.add(defenseBoost1);
        root.children.add(dexerityBoost1);
        root.children.add(attackBoost1);

        //Layer 2: Input: healthBoost1, defenseBoost1,
        // Skill HealSkill = new module1.Skills.HealSkill(0)
        // root.children.add(healthBoost2);
        // root.children.add(defenseBoost2);
        // root.children.add(dexerityBoost2);
        // root.children.add(attackBoost2);
    }

    public void checkStatBoosts(Skill skill){
        for (Skill node : skill.children){
            if (node.skillType.equals("Health Boost")){
                currentStatBoosts[0] += node.value;
            }
            else if(node.skillType.equals("Defence Boost")){
                currentStatBoosts[1] += node.value;
            }
            else if(node.skillType.equals("Dexterity Boost")){
                currentStatBoosts[2] += node.value;
            }
            else if(node.skillType.equals("Attack Boost")){
                currentStatBoosts[3] += node.value;
            }
            
            checkStatBoosts(node);
        }
    }
}
