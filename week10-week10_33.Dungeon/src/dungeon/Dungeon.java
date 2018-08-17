package dungeon;

import dungeon.logic.Character;
import dungeon.logic.Player;
import dungeon.logic.Vampire;
import dungeon.ui.TextUserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

    private List<Vampire> vampires;
    private Player player;
    private Character[][] grid;
    private int height, length;
    private boolean isOver;
    private int moves;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        grid = new Character[height][length];
        this.height = height;
        this.length = length;
        this.moves = moves;
        player = new Player();
        this.vampires = new ArrayList<Vampire>();
        setupPlayer();
        setupVampires(vampires, vampiresMove);
    }

    public List<Vampire> getVampires() {
        return vampires;
    }

    public Player getPlayer() {
        return player;
    }

    public Character[][] getGrid() {
        return grid;
    }

    public boolean isOver() {
        return isOver;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public boolean areVampiresDead(){
        return vampires.isEmpty();
    }

    public int getMoves() {
        return moves;
    }

    public void run(){
        TextUserInterface ui = new TextUserInterface(this);
        while (!isOver){
            ui.doTurn();
        }
        System.out.println();
        if (areVampiresDead()) System.out.println("YOU WIN");
        else System.out.println("YOU LOSE");
    }

    public void turn(String input){
        char[] chars = input.toCharArray();
        for (char ch : chars){
            tick(ch);
        }
        moves--;
        if (moves < 1 || vampires.isEmpty()){
            isOver = true;
        }
    }

    private void tick(char input){
        move(input, player);
        List<Vampire> kills = update();
        for (Vampire vampire : vampires){
            move(randomDirection(), vampire);
            kills.addAll( update());
        }
        vampires.removeAll(kills);
    }

    private void setupPlayer(){
        this.player = new Player();
        grid[0][0] = player;
    }

    private void setupVampires(int number, boolean allowedToMove){
        int i = 0;
        while (i < number){
            int coord[] = randomCoord();
            Vampire vampire = new Vampire(coord[0], coord[1], allowedToMove);
            grid[vampire.getY()][vampire.getX()] = vampire;
            vampires.add(vampire);
            i++;
        }
    }


    private void move(char direction, Character character){
        int[]coord = getNewCoord(direction, character);
        int dx = coord[0];
        int dy = coord[1];
        if (isValid(character, dx, dy)){
            this.grid[character.getY()][character.getX()] = null;
            character.setX(dx);
            character.setY(dy);
        }
    }

    private int[] getNewCoord(char direction, Character character){
        int dx, dy;
        if (direction == ('w')){
            dy = character.getY() - 1;
            dx = character.getX();
        } else if (direction == ('s')){
            dy = character.getY() + 1;
            dx = character.getX();
        } else if (direction == ('d')){
            dy = character.getY();
            dx = character.getX() + 1;
        } else {
            dy = character.getY();
            dx = character.getX() - 1;
        }
        int[] coord = {dx,dy};
        return coord;
    }

    private char randomDirection(){
        char[] directions = {'w', 'a', 's', 'd'};
        return directions[new Random().nextInt(4)];
    }

    private int[] randomCoord(){
        Random rand = new Random();
        int dx = rand.nextInt(getLength());
        int dy = rand.nextInt(getHeight());
        while (grid[dy][dx] != null){
            dx = rand.nextInt(getLength());
            dy = rand.nextInt(getHeight());
        }
        int[] coord = {dx, dy};
        return coord;
    }

    private List<Vampire> update(){
        List<Vampire> killed = new ArrayList<Vampire>();
        grid[player.getY()][player.getX()] = player;
        for (Vampire vampire : vampires){
            if (grid[vampire.getY()][vampire.getX()] == null){
                grid[vampire.getY()][vampire.getX()] = vampire;
            } else if (grid[vampire.getY()][vampire.getX()].equals(player)){
                killed.add(vampire);
            } else {
                //vampire tried to move to an illegal spot
            }
        }
        return killed;
    }


    private boolean isValid(Character character, int dx, int dy){
        if (!character.allowedToMove()) return false;
        if (dy >= this.getHeight() || dy < 0) return false;
        if (dx >= this.getLength() || dx < 0) return false;
        if (grid[dy][dx] == null) return true;
        return !character.getClass().equals(grid[dy][dx].getClass());
    }



}
