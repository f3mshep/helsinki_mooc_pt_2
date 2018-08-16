import phonebook.ui.TextUserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        String input = ""
                + "1\njukka\n02-212121\n"
                + "4\npekka\nmannerheimintie\nhelsinki\n"
                + "1\npekka\n09-12345\n"
                + "1\npekka\n09-54321\n"
                + "7\npekka\n"
                + "x\n";
        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader);
        ui.start();
    }
}
