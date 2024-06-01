package module1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

public class DialogueHandler{
    File dialogueDir = new File("rpg\\assets\\dialogue");
    File[] dialogueListing = dialogueDir.listFiles();

    HashMap<String, List<String>> dialogue;

    public void displayText(String text){
        //Display text on the frame
    }

    public DialogueHandler(){
        dialogue = new HashMap<String, List<String>>();

        try {
            for (File file : dialogueListing)
            {
                Scanner myReader = new Scanner(file);
                List<String> tempDialogue = new ArrayList<String>();
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    tempDialogue.add(data);
                }
                dialogue.put(file.getName(), tempDialogue);
                myReader.close();
            }
        } catch (FileNotFoundException e){System.out.println("File not found.");} 
    }
    
    public List<String> getDialogue(String name) {
        return dialogue.get(name);
    }
}
