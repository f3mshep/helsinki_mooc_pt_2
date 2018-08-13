import java.util.Scanner;

public class Reader {

    private final Scanner reader = new Scanner(System.in);

    public String readString(){
        return this.reader.nextLine();
    }

    public int readInteger(){
        return Integer.parseInt(this.reader.nextLine());
    }

}
