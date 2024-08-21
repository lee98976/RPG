package module1.UIElements;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class HealthBar extends JPanel {
    JPanel healthPart;
    JPanel healthBGPart;
    int healthBarWidth;
    int healthBarHeight;
    Color maxHealthColor = new Color(0, 255, 0);
    Color minHealthColor = new Color(255, 0, 0);

    public HealthBar(int x, int y, int width, int height) {
        this.healthBarWidth = width;
        this.healthBarHeight = height;

        setLayout(null);
        setBackground(new Color(127, 127, 127));
        setBounds(x, y, width, height);
        
        healthPart = new JPanel();
        healthPart.setBackground(new Color(0, 255, 0));
        healthPart.setBounds(10, 10, width - 20, height - 20);

        healthBGPart = new JPanel();
        healthBGPart.setBackground(new Color(0, 0, 0));
        healthBGPart.setBounds(10, 10, width - 20, height - 20);

        add(healthPart);
        add(healthBGPart);
    }

    public Color blendColorsByRatio(float healthPercentage) {
        return new Color((healthPercentage * maxHealthColor.getRed() + (1-healthPercentage) * minHealthColor.getRed()) / 255,
                         (healthPercentage * maxHealthColor.getGreen() + (1-healthPercentage) * minHealthColor.getGreen()) / 255,
                         (healthPercentage * maxHealthColor.getBlue() + (1-healthPercentage) * minHealthColor.getBlue()) / 255);
    }

    public void updateHealthBar(float healthPercentage) {
        healthPart.setSize(Math.round((healthBarWidth - 20) * healthPercentage), healthBarHeight - 20);
        healthPart.setBackground(blendColorsByRatio(healthPercentage));
        healthPart.revalidate();
    }
}
