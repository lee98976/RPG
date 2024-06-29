package module1.Skills;
import module1.Entity;

public class StatBuffSkill extends Skill{
    
    public StatBuffSkill(int amount, String type) {
        super(amount);
        this.skillName = type;
        this.skillType = type;
    }

    @Override
    public void doSkill(Entity user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doSkill'");
    }

    @Override
    public void doSkill(Entity user, Entity reciever) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doSkill'");
    }

    @Override
    public void doSkill(Entity user, Entity[] recievers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doSkill'");
    }
}
