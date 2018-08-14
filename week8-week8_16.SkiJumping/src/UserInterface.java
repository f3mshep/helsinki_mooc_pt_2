import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner reader;
    ArrayList<String> names = new ArrayList<String>();
    RoundDatabase roundDatabase;

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start(){
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        handleNames();
        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println();
        handleRounds();
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
        handleResults();
    }

    private void handleNames(){
        while (true){
            System.out.println("  Participant name:");
            String name = this.reader.nextLine();
            if (name.isEmpty()) break;
            names.add(name);
        }
        roundDatabase = new RoundDatabase(this.names);
    }

    private void handleRounds(){
        int currentRound = 1;
        while (true){
            System.out.println();
            System.out.println("Write \"jump\" to jump; otherwise you quit: jump");
            String input = reader.nextLine();
            if (!input.equals("jump")) break;
            System.out.println();
            System.out.println("Round " + currentRound);
            System.out.println();
            System.out.println("Jumping order:");
            ArrayList<Skier>  order = roundDatabase.getJumpingOrder();
            int skierCount = 1;
            for (Skier skier :order){
                System.out.println("  " + skierCount + ". " + skier);
                skierCount++;
            }
            System.out.println();
            System.out.println("Results of round " + currentRound);
            roundDatabase.doRound();
            List<SkierRound> skierRounds = roundDatabase.getRound(currentRound);
            for (SkierRound skierRound : skierRounds){
                System.out.println(skierRound);
            }
            currentRound++;
        }
    }

    private void handleResults(){
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        ArrayList<Skier> order = this.roundDatabase.getScoreOrder();
        int count = 1;
        for (Skier skier : order){
            System.out.println(count + "           " + skier);
            System.out.println("            " + skier.jumpLengthsToString());
            count++;
        }
    }

}
