package module1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HealthBar extends JPanel {
    JPanel healthPart;

    public HealthBar(int x, int y) {
        setLayout(new GridLayout(1, 1, 5, 5));
        setBackground(new Color(127, 127, 127));
        setBounds(x, y, 200, 100);
        
        healthPart = new JPanel();
        healthPart.setBackground(new Color(0, 255, 0));
        healthPart.setBounds(x+10, y+10, 180, 80);

        add(healthPart);
    }

    public void updateHealthBar(float healthPercentage) {
        healthPart.setSize(Math.round(180 * healthPercentage), 80);
        healthPart.revalidate();
    }
}
