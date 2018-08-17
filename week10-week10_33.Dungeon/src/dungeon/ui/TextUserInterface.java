package dungeon.ui;

import dungeon.Dungeon;
import dungeon.logic.Vampire;
import dungeon.logic.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUserInterface {

    private Dungeon dungeon;
    private Scanner reader = new Scanner(System.in);
    private final List<java.lang.Character> permittedInput = new ArrayList<java.lang.Character>();

    public TextUserInterface(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void doTurn(){
        printMovesLeft();
        System.out.println();
        printLocations();
        System.out.println();
        printMap();
        String input = getDirection();
        dungeon.turn(input);
    }

    public void printMovesLeft(){
        System.out.println(dungeon.getMoves());
    }

    public void printLocations(){
        System.out.println(dungeon.getPlayer());
        for (Vampire vampire : dungeon.getVampires()){
            System.out.println(vampire);
        }
    }

    public void printMap(){
        Character[][] grid = dungeon.getGrid();
        for (Character[] row : grid){
            for (Character slot : row){
                if (slot == null) System.out.print(".");
                else System.out.print(slot.getToken());
            }
            System.out.println();
        }
    }

    public String getDirection(){
        String input = reader.nextLine();
        char[] inputArr =  input.toCharArray();
        return input;
    }

}
