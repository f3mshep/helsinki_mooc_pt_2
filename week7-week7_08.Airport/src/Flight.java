public class Flight {

    private Plane plane;
    private String depart;
    private String dest;


    public Flight(Plane plane, String depart, String dest) {
        this.plane = plane;
        this.depart = depart;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return this.plane.toString() + " (" + this.depart + "-" + this.dest + ")";
    }
}
