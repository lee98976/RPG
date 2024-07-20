package module1;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class BGPanel extends JPanel{
    private Image bg;


public BGPanel(int bgSelect) throws IOException{
    bg = ImageIO.read(new File("Forest.png"));


    
}
}