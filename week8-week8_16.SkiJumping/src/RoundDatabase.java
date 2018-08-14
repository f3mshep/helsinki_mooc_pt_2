import java.util.*;

public class RoundDatabase {

    private int currentRound;
    Map<Integer, List<SkierRound>> rounds = new HashMap<Integer, List<SkierRound>>();
    ArrayList<Skier> skiers = new ArrayList<Skier>();
    ArrayList<Skier> order = new ArrayList<Skier>();

    public RoundDatabase(ArrayList<String> names) {
        Skier newSkier;
        for (String name : names){
            newSkier = new Skier(name);
            skiers.add(newSkier);
            order.add(newSkier);
        }
    }

    public ArrayList<Skier> getJumpingOrder(){
        Collections.sort(this.order);
        return order;
    }

    public ArrayList<Skier> getScoreOrder(){
        Collections.sort(this.order);
        Collections.reverse(this.order);
        return order;
    }

    public List<SkierRound> getRound(Integer roundNum){
        return rounds.get(roundNum);
    }

    public void doRound(){
        this.currentRound++;
        rounds.put(currentRound, new ArrayList<SkierRound>());
        SkierRound skierRound;
        for (Skier skier : skiers){
            skierRound = new SkierRound(skier, this.currentRound);
            rounds.get(currentRound).add(skierRound);
        }
    }
}
