import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things = new ArrayList<Thing>();
    private int max;
    private Thing heaviest;


    public Suitcase(int max) {
        this.max = max;
    }

    public void addThing(Thing thing){
        if (totalWeight() + thing.getWeight() <= this.max){
            if (heaviest == null) heaviest = thing;
            if (thing.getWeight() > heaviest.getWeight()) heaviest = thing;
            things.add(thing);
        }
    }

    public Thing heaviestThing(){
        return heaviest;
    }

    public int totalWeight(){
        int total = 0;
        for (Thing thing : things){
            total += thing.getWeight();
        }
        return total;
    }

    public void printThings(){
        for (Thing thing : this.things){
            System.out.println(thing);
        }
    }

    @Override
    public String toString() {
        if (things.size() == 0) return "empty (0 kg)";
        if (things.size() == 1) return "1 thing " + "(" + totalWeight() + "kg)";
        int count = things.size();
        return count + " things " + "(" + totalWeight() + "kg)";
    }
}
