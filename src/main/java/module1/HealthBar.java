package module1;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class HealthBar extends JPanel {
    JPanel healthPart;
    int healthBarWidth;
    int healthBarHeight;
    Color maxHealthColor = new Color(0, 255, 0);
    Color minHealthColor = new Color(255, 0, 0);

    public HealthBar(int x, int y, int width, int height) {
        this.healthBarWidth = width;
        this.healthBarHeight = height;

        setLayout(new FlowLayout());
        setBackground(new Color(127, 127, 127));
        setBounds(x, y, width, height);
        
        healthPart = new JPanel();
        healthPart.setBackground(new Color(0, 255, 0));
        healthPart.setBounds(x+10, y+10, 180, 80);

        add(healthPart);
    }

    public Color blendColorsByRatio(float healthPercentage) {
        return new Color((healthPercentage * maxHealthColor.getRed() + (1-healthPercentage) * minHealthColor.getRed()) / 255,
                         (healthPercentage * maxHealthColor.getGreen() + (1-healthPercentage) * minHealthColor.getGreen()) / 255,
                         (healthPercentage * maxHealthColor.getBlue() + (1-healthPercentage) * minHealthColor.getBlue()) / 255);
    }

    public void updateHealthBar(float healthPercentage) {
        healthPart.setSize(Math.round(180 * healthPercentage), 80);
        healthPart.setBackground(blendColorsByRatio(healthPercentage));
        healthPart.revalidate();
    }
}
