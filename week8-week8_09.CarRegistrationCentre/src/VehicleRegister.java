import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String >();

    public boolean add(RegistrationPlate plate, String owner){
        if (this.owners.get(plate) == null){
            this.owners.put(plate, owner);
            return true;
        } else {
            return false;
        }

    }

    public String get(RegistrationPlate plate){
        return this.owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate){
        if (this.owners.get(plate) == null) return false;
        this.owners.remove(plate);
        return true;

    }

    public void printRegistrationPlates(){
        for (RegistrationPlate plate : this.owners.keySet()){
            System.out.println(plate);
        }
    }

    public void printOwners(){
        ArrayList<String> uniqueOwners = new ArrayList<String>();
        for (RegistrationPlate plate : this.owners.keySet()){
            String owner = this.owners.get(plate);
            if (!uniqueOwners.contains(owner)) {
                uniqueOwners.add(owner);
                System.out.println(owner);
            }
        }
    }

}
