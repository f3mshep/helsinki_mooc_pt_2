package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows = new ArrayList<Cow>();

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }

    public void addCow(Cow cow){
        cows.add(cow);
    }

    public void manageCows(){
        barn.takeCareOf(cows);
    }

    public String getOwner() {
        return owner;
    }

    public void installMilkingRobot(MilkingRobot robot){
        barn.installMilkingRobot(robot);
    }

    @Override
    public void liveHour() {
        for (Cow cow :cows){
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: " + this.owner + "\n");
        sb.append("Barn bulk tank: " + this.barn.getBulkTank().toString() + "\n");
        if (cows.isEmpty()){
            sb.append("No cows.");
        } else {
            sb.append("Animals:\n");
            for (Cow cow : cows){
                sb.append("        " + cow.toString() + "\n");
            }
        }
        return sb.toString();
    }
}
