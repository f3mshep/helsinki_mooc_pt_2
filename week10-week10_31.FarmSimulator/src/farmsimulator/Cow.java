package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable {

    private String name;
    private double capacity;
    private double amount;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow(){
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name){
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.amount = 0;
    }

    @Override
    public double milk() {
        double tempAmountOfMilk = this.amount;
        this.amount = 0;
        return tempAmountOfMilk;
    }

    @Override
    public void liveHour() {
        double milkProduced = Math.ceil(0.7 + (2 - 0.7) * new Random().nextDouble());
        if(this.amount + milkProduced <= this.capacity){
            this.amount += milkProduced;
        } else {
            this.amount = this.capacity;
        }
    }


    @Override
    public String toString() {
        return this.name + " " + this.amount + "/" + this.capacity;
    }

    public String getName(){
        return this.name;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getAmount(){
        return this.amount;
    }



}
