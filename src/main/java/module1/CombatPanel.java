package module1;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CombatPanel extends JPanel{
    public CombatPanel() {
        Color bgColor = new Color(128, 56, 245);
        setBackground(bgColor);
        setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            add(new JButton("" + i));
        }
    }
}
