package farmsimulator;

public class BulkTank {

    private double capacity, volume;

    public BulkTank(){
        this.capacity = 2000.0;
    }
    public BulkTank(double capacity){
        this.capacity = capacity;
    }
    public double getCapacity(){
        return this.capacity;
    }

    public double getVolume(){
        return this.volume;
    }

    public double howMuchFreeSpace(){
        return this.capacity - this.volume;
    }

    public void addToTank(double amount){
        if (amount + volume > capacity) volume = capacity;
        else volume += amount;
    }

    public double getFromTank(double amount){
        double amountTaken;
        if (amount > volume) amountTaken = volume;
        else amountTaken = amount;
        this.volume -= amountTaken;
        return amountTaken;
    }

    @Override
    public String toString() {
        return  Math.ceil(this.volume) + "/" +  Math.ceil(this.capacity);
    }
}
