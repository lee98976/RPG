package module1;

public class Enemy extends Entity{
    private int exp;
	public Enemy(String name) {
		super(name);
        

		//TODO Auto-generated constructor stub
	}
    public Enemy(String name, int level, int pwr, int def, int maxHp, int role, SkillTree skillTree){
        super(name, level, pwr, def, maxHp);
    }
    public int EnemygetExp(Player player) {
        return exp;
    }
}
