import java.util.HashMap;
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    private void menu(){
        System.out.println("Statement:");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");
        System.out.println("    quit - quits the text user interface");
    }

    private void translate(){
        System.out.println("Give a word:");
        String key = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(key));
    }

    private void add(){
        System.out.println("What word would you like to add?");
        String key = reader.nextLine();
        System.out.println("What is the translation?");
        String value = reader.nextLine();
        dictionary.add(key, value);
    }

    public void start(){
        while (true){
            menu();
            String input = reader.nextLine();
            if (input.equals("quit")){
                break;
            } else if(input.equals("add")) {
                add();
            } else if(input.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown Statement");
            }
        }
        System.out.println("Cheers!");
    }
}
