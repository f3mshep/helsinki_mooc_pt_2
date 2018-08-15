package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Integer> readings = new ArrayList<Integer>();

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

    public List<Integer> readings(){
        return this.readings;
    }


    @Override
    public boolean isOn() {
        for (Sensor sensor :sensors){
            if (!sensor.isOn()) return false;
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor :sensors){
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor :sensors){
            sensor.off();
        }
    }

    @Override

    public int measure() {
        int total = 0;
        for (Sensor sensor :sensors){

            total += sensor.measure();
        }
        int reading = total / sensors.size();
        this.readings.add(reading);
        return reading;
    }
}
