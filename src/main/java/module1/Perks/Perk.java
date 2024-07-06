package module1.Perks;

import java.util.ArrayList;

public class Perk {
    // Define these at start
    String skillName;
    public String type;
    public double value;

    // Define these later
    public ArrayList<Perk> children;
    public Perk parent;
    boolean owned;

    public Perk(double value, String type) {
        this.value = value;
        this.type = type;
        this.children = new ArrayList<Perk>();
    }

}
