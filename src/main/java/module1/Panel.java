package module1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel{
    
    private Image image;

    public Panel(Image image) {
        this.image = image;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
