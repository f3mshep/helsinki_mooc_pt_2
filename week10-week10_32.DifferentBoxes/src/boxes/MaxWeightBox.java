package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> things = new ArrayList<Thing>();

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getWeight(){
        int weight = 0;
        for (Thing thing : things){
            weight += thing.getWeight();
        }
        return weight;
    }

    @Override
    public void add(Thing thing) {
       if (thing.getWeight() + getWeight() <= this.maxWeight) things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
}
