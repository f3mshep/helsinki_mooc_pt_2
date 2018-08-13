import java.util.ArrayList;

public class Plane {

    private String id;
    private int capacity;
//    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public Plane(String ID, int capacity) {
        this.id = ID;
        this.capacity = capacity;
    }

//    public void addFlight(Flight flight){
//        flights.add(flight);
//    }
//
//    public ArrayList<Flight> getFlights() {
//        return flights;
//    }

    @Override
    public String toString() {
        return this.id + " (" + this.capacity + " ppl)";
    }
}
