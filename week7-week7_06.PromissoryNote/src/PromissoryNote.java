import java.util.HashMap;

public class PromissoryNote {

    private final HashMap<String, Double> loans = new HashMap<String, Double>();

    public void setLoan(String name, double amount){
        loans.put(name, amount);
    }

    public double howMuchIsTheDebt(String name){
        if (loans.get(name) == null) return 0;
        return loans.get(name);
    }

}
