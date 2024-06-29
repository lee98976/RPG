package module1.Skills;
import java.util.ArrayList;
import module1.Entity;

public abstract class Skill {
    //Define these at start
    String skillName;
    public String skillType;
    public double value;

    //Define these later
    public ArrayList<Skill> children;
    public Skill parent;
    boolean owned;

    public Skill(double value){
        this.value = value;
        this.children = new ArrayList<Skill>();
    }
0
    public abstract void doSkill(Entity user);
    public abstract void doSkill(Entity user, Entity reciever);
    public abstract void doSkill(Entity user, Entity[] recievers);
}
