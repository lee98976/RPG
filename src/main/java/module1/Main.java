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
            }
        });
    }
}