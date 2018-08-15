package application;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean isOn;

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (!this.isOn()){
            throw new IllegalStateException();
        } else {
            return getRandomNumberInRange(-30,30);
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
