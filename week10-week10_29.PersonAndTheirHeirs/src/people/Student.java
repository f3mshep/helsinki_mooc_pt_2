package people;

public class Student extends Person {

    private int credits;

    public Student(String name, String address) {
        super(name, address);
    }

    public void study(){
        this.credits++;
    }

    public int credits(){
        return this.credits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb + "\n  credits " + this.credits;
    }
}
