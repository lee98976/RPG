package module1;


public class Player {
    private double height ;
    private String job;
    private String name;
    private int level;
    private int exp;
    private int pwr;
    private int def;
    private int maxHp;
    private int currentHp;

    public Player(String name){
      init();
      this.name = name;
    } 

    public Player(String name, double height){
        init();
        this.height = height;
        this.name = name;

    }
   
    
    private void init(){
        level = 1;
        exp = 0;
        pwr = 1;
        def = 1;
        maxHp = 100;
        currentHp = maxHp;


        
    }
}

