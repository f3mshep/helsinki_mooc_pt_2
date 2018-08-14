import java.util.ArrayList;
import java.util.stream.Collectors;

public class Skier implements Comparable<Skier> {

    private int points;
    private String name;
    private ArrayList<Integer> jumpLengths = new ArrayList<Integer>();

    public Skier(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addJump(int len){
        this.jumpLengths.add(len);
    }


    public void addPoints(int amount){
        if (amount > 0) this.points += amount;
    }

    public String jumpLengthsToString(){
        String str = "jump lengths: ";
        String listString = "";
        for (int i = 0; i < this.jumpLengths.size() - 1; i++) {
            listString +=  jumpLengths.get(i) + " m, ";
        }
        return str + listString + this.jumpLengths.get(this.jumpLengths.size() - 1) + " m";
    }

    @Override
    public String toString() {
        return name + " (" + this.getPoints() + " points)";
    }

    @Override
    public int compareTo(Skier skier) {
        return this.points -  skier.points;
    }


}
