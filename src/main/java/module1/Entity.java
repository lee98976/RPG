package module1;

public class Entity {
    protected String name;
    protected int level;
    protected int pwr;
    protected int def;
    protected int maxHp;
    protected int currentHp;

    public Entity(String name, int level, int pwr, int def, int maxHp){
        this.name = name;
        this.level = level;
        this.pwr = pwr;
        this.def = def;
        this.maxHp = maxHp;
    }

    public Entity(String name){
        initialize();
    }

    protected void initialize(){
        level = 1;
        pwr = 1;
        def = 1;
        maxHp = 100;
        currentHp = maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPwr() {
        return pwr;
    }

    public void setPwr(int pwr) {
        this.pwr = pwr;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
