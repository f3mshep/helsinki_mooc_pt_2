import java.util.ArrayList;

public class Container {

    private ArrayList<Suitcase> suitcases = new ArrayList<Suitcase>();
    private int max;

    public Container(int max) {
        this.max = max;
    }

    public void addSuitcase(Suitcase suitcase){
        if (totalWeight() + suitcase.totalWeight() <= this.max){
            suitcases.add(suitcase);
        }
    }

    private int totalWeight(){
        int total = 0;
        for (Suitcase suitcase : suitcases){
            total += suitcase.totalWeight();
        }
        return total;
    }

    public void printThings(){
        for (Suitcase suitcase : suitcases){
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases ("+ totalWeight() +"kg)";
    }
}
