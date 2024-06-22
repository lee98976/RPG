package module1.Skills;

import module1.Entity;

public abstract class Skill {
    String skillName;
    public String skillType;
    public double value;
    public Skill[] children;
    Skill parent;
    boolean owned;

    public Skill(double value){
        this.value = value;
    }

    public abstract void doSkill(Entity user);
    public abstract void doSkill(Entity user, Entity reciever);
    public abstract void doSkill(Entity user, Entity[] recievers);
}
