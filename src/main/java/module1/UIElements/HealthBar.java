package module1.UIElements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class HealthBar extends JPanel {
    JPanel healthPart;
    JPanel recentDamagePart;
    JPanel healthBGPart;
    int healthBarWidth;
    int healthBarHeight;
    Color maxHealthColor = new Color(0, 255, 0);
    Color minHealthColor = new Color(255, 0, 0);

    // Animation Related: //
    int frames = 0;
    float moveDistance = 0;
    Timer animTimer;

    public HealthBar(int x, int y, int width, int height) {
        this.healthBarWidth = width;
        this.healthBarHeight = height;

        setLayout(null);
        setBackground(new Color(127, 127, 127));
        setBounds(x, y, width, height);
        
        healthPart = new JPanel();
        healthPart.setBackground(new Color(0, 255, 0));
        healthPart.setBounds(10, 10, width - 20, height - 20);

        recentDamagePart = new JPanel();
        recentDamagePart.setBackground(new Color(171, 35, 40));
        recentDamagePart.setBounds(10, 10, width - 20, height - 20);

        healthBGPart = new JPanel();
        healthBGPart.setBackground(new Color(0, 0, 0));
        healthBGPart.setBounds(10, 10, width - 20, height - 20);

        add(healthPart);
        add(recentDamagePart);
        add(healthBGPart);
    }

    public Color blendColorsByRatio(float healthPercentage) {
        return new Color((healthPercentage * maxHealthColor.getRed() + (1-healthPercentage) * minHealthColor.getRed()) / 255,
                         (healthPercentage * maxHealthColor.getGreen() + (1-healthPercentage) * minHealthColor.getGreen()) / 255,
                         (healthPercentage * maxHealthColor.getBlue() + (1-healthPercentage) * minHealthColor.getBlue()) / 255);
    }

    public void recentDamageAnim() {
        frames += 1;
        // 81 to 160 inclusive
        if (frames > 80 && frames <= 160) {
            float currentDuration = (float) (frames - 80f) / 80f;
            // System.out.println(recentDamagePart.getWidth());
            System.out.println(currentDuration);
            recentDamagePart.setSize((int) (healthPart.getWidth() + moveDistance * ((1-currentDuration) * (1-currentDuration))), healthPart.getHeight());
            revalidate();
        } else if (frames > 160) {
            animTimer.stop();
        }
    }



    public void updateHealthBar(float healthPercentage) {
        healthPart.setSize(Math.round((healthBarWidth - 20) * healthPercentage), healthBarHeight - 20);
        healthPart.setBackground(blendColorsByRatio(healthPercentage));
        healthPart.revalidate();

        frames = 0;
        moveDistance = recentDamagePart.getWidth() - healthPart.getWidth();
        animTimer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                recentDamageAnim();
            }
        });
        animTimer.start();
    }
}
