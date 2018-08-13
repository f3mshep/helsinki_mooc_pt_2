
public class Main {

    private static final int MAX_SUITCASES = 100;

    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        // adding 100 suitcases with one brick in each
        int i = 0;
        int brickWeight = 1;
        while (i < MAX_SUITCASES){
            Thing brick = new Thing("brick", brickWeight);
            Suitcase suitcase = new Suitcase(brickWeight);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
            brickWeight++;
            i++;
        }
    }


}
