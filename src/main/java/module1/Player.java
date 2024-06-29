package module1;
import java.util.Scanner;
import module1.SkillTree;
import module1.Skills.StatBuffSkill;

public class Player extends Entity{
    private Scanner scanner = new Scanner(System.in);
    private int exp;
    private String role;
    private SkillTree skillTree;
    private DialogueHandler text = new DialogueHandler();

    //Load data

    public Player(String name, int level, int health, int defense, int dexterity, int attack, String role, SkillTree skillTree){
        super(name, level, health, defense, dexterity, attack);
        this.role = role;
        this.exp = 0;
        this.skillTree = skillTree;
    }

    //New character
    public Player(String name) throws InterruptedException{
        super(name);
        exp = 0;
        role = "warrior";
        skillTree = new SkillTree(new StatBuffSkill(0, "Health Boost"));
        //text.dialogue("intro.txt");
    }

    public void checkLevel(){
        while (exp >= 50 * Math.pow(1.1, this.level)) {
            exp -= 50 * Math.pow(1.1, this.level);
            level += 1;
            health = 1;
            // TODO add level up problems
        }
    }

    public int GetExp(){
        return exp;
    }

}



