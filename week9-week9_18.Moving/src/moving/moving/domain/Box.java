package moving.domain;

import java.util.ArrayList;

public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> things = new ArrayList<Thing>();

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public boolean addThing(Thing thing){
        if (this.getVolume() + thing.getVolume() <= this.maximumCapacity){
            this.things.add(thing);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int getVolume() {
        int total = 0;
        for (Thing thing:things){
            total += thing.getVolume();
        }
        return total;
    }
}
