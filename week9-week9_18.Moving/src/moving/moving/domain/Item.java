package moving.domain;

public class Item implements Thing, Comparable<Item> {

    private int volume;
    private String name;

    public Item(String name, int volume) {
        this.volume = volume;
        this.name = name;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Item item) {
        return this.volume - item.volume;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.volume + " dm^3)";
    }
}
