import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> sightings = new HashMap<Bird, List<String>>();

    public void observe(Bird bird, String location){
        List<String> locations = sightings.get(bird);
        if (locations == null){
            locations = new ArrayList<String>();
            sightings.put(bird, locations);
        }
        locations.add(location);
    }

    public void observations(Bird bird){
        List<String> locations = sightings.get(bird);
        if (locations == null) System.out.println(bird + " observations: 0");
        else {
            System.out.println(bird + " observations: " + locations.size());
            for (String location : locations){
                System.out.println(location);
            }
        }
    }

}
