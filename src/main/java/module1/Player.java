package module1;
import java.util.Scanner;

public class Player extends Entity{
    private Scanner scanner = new Scanner(System.in);
    private int exp;
    private String role;
    private SkillTree skillTree;
    private DialogueHandler text = new DialogueHandler();

    //Load data

    public Player(String name, int level, int pwr, int def, int maxHp, int role, SkillTree skillTree){
        super(name, level, pwr, def, maxHp);
        this.name = name;
        this.exp = 0;
        this.skillTree = skillTree;
    }

    //New character
    public Player(String name) throws InterruptedException{
        super(name);
        this.exp = 0;
        this.role = "warrior";
        this.skillTree = new SkillTree();
        //text.dialogue("intro.txt");
    }
    public int GetExp(){
        return exp;
    }

    }



