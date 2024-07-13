package module1;

import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Screen screen = new Screen();
                    screen.battleScene();
                    Player player = new Player("Jeff");
                } catch (InterruptedException e) {
                }
                // DialogueText label = new DialogueText(text.getDialogue("intro.txt"));
                // label.setHorizontalTextPosition(JLabel.CENTER);
                // label.setHorizontalAlignment(JLabel.CENTER);
                // label.setFont();
                // label.fancyText("sdifhsdbionerwiofruebioqetu
                // [3q0ascwreh536354grwegewgfeb4g45ou24gu245pogj4go4jg42g9458 9w08 r908
                // asd90gaudf90g90e4jg 90dajg90ersjn90tuy90eayad90fgu0sdfj90 s9d0gubj59w0",
                // screen);
            }
        });
    }
}