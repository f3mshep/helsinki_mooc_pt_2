package application;

public class ConstantSensor implements Sensor {

    private int constant;

    public ConstantSensor(int constant) {
        this.constant = constant;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return this.constant;
    }
}
