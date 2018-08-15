package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things){
        ArrayList<Box> boxes = new ArrayList<Box>();
        Box currentBox = new Box(this.boxesVolume);
        for (Thing thing: things){
            if (!currentBox.addThing(thing)){
                boxes.add(currentBox);
                currentBox = new Box(this.boxesVolume);
                currentBox.addThing(thing);
            }
        }
        boxes.add(currentBox);
        return boxes;
    }
}
