import java.util.ArrayList;

public class Box implements ToBeStored {

    private double maxWeight;
    private ArrayList<ToBeStored> items = new ArrayList<ToBeStored>();

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void add(ToBeStored item){
        if (item.weight() + this.weight() <= maxWeight) items.add(item);
    }

    public double weight(){
        double total = 0;
        for (ToBeStored item : items){
            total += item.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " things, " + "total weight " + this.weight() + " kg";
    }
}
