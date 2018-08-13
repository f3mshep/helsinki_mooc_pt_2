import java.util.ArrayList;
import java.util.HashMap;

public class FlightDatabase {
    HashMap<String, Plane> planes = new HashMap<String, Plane>();
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public void printPlanes(){
        for ( String key : planes.keySet() ){
            System.out.println(planes.get(key));
        }
    }

    public void printFlights(){
        for ( Flight flight : flights ){
            System.out.println(flight);
        }
    }


    public void printPlaneInfo(String id){
        Plane plane = getPlane(id);
        System.out.println(plane);
    }

    public void addPlane(String id, int capacity){
        Plane newPlane = new Plane(id, capacity);
        planes.put(id, newPlane);
    }

    public void addFlight(String id, String dept, String dest){
        Plane plane = getPlane(id);
        Flight newFlight = new Flight(plane, dept, dest);
        flights.add(newFlight);
    }

    private Plane getPlane(String id){
        Plane plane = planes.get(id);
        if (plane == null) {
            throw new java.lang.RuntimeException("Plane does not exist with that ID.");
        }
        return plane;
    }

}
