package farmsimulator;

public class MilkingRobot {

    private BulkTank bulkTank;

    public void setBulkTank(BulkTank bulkTank) {
        this.bulkTank = bulkTank;
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }

    public void milk(Milkable cow){
        if(bulkTank == null) throw new IllegalStateException();
        double amount = cow.milk();
        bulkTank.addToTank(amount);
    }
}
