package containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {

    private List<Double> history = new ArrayList<Double>();

    public void add(double situation){
        history.add(situation);
    }

    public void reset(){
        this.history.clear();
    }

    public double minValue(){
        if (history.isEmpty()) return 0;
        double min = history.get(0);
        for (double num : history){
            if (num < min) min = num;
        }
        return min;
    }

    public double maxValue(){
        if (history.isEmpty()) return 0;
        double max = history.get(0);
        for (double num :history){
            if (num > max) max = num;
        }
        return max;
    }

    public double average(){
        if (history.isEmpty()) return 0;
        double sum = 0;
        for (double num :history){
            sum += num;
        }
        return sum / history.size();
    }


    public double greatestFluctuation() {
        if (this.history.size() > 1) {
            double greatestFluctuation = Math.abs(this.history.get(0) - this.history.get(1));

            for (int i = 0; i < this.history.size() - 1; i++) {
                double comparedFluctuation = Math.abs(this.history.get(i) - this.history.get(i + 1));
                if (comparedFluctuation > greatestFluctuation) {
                    greatestFluctuation = comparedFluctuation;
                }
            }

            return greatestFluctuation;
        }

        return 0;
    }

    public double variance() {
        if (this.history.size() > 1) {
            double variance = 0;

            for (double value : this.history) {
                variance += Math.pow(value - this.average(), 2);
            }

            return variance / (this.history.size() - 1) ;
        }

        return 0;
    }

    @Override
    public String toString() {
        return history.toString();
    }
}
