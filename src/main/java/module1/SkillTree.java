package module1;
import java.util.TreeSet;
import module1.Skills.Skill;

public class SkillTree {
    private Skill root;
    private int[] currentStatBoosts;

    public SkillTree(Skill startingSkill){
        root = startingSkill;
        currentStatBoosts = new int[3];
    }

    public void checkStatBoosts(Skill skill){
        for (Skill node : skill.children){
            if (node.skillType.equals("Health Boost")){
                currentStatBoosts[0] += node.value;
            }
            else if(node.skillType.equals("Defence Boost")){
                currentStatBoosts[1] += node.value;
            }
            else{
                currentStatBoosts[2] += node.value;
            }
            
            checkStatBoosts(node);
        }
    }
}
