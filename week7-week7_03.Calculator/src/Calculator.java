public class Calculator {

    private final Reader reader = new Reader();
    private int calculations;



    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    private void sum(){
        incrementCount();
        System.out.println("value1: ");
        int a = reader.readInteger();
        System.out.println("value2: ");
        int b = reader.readInteger();
        System.out.println("sum of the values " + (a + b));
    }

    private void difference(){
        incrementCount();
        System.out.println("value1: ");
        int a = reader.readInteger();
        System.out.println("value2: ");
        int b = reader.readInteger();
        System.out.println("difference of the values " + (a - b));
    }

    private void product(){
        incrementCount();
        System.out.println("value1: ");
        int a = reader.readInteger();
        System.out.println("value2: ");
        int b = reader.readInteger();
        System.out.println("product of the values " + (a * b));
    }

    private void statistics(){
        System.out.println("Calculations done " + this.calculations);
    }

    private void incrementCount(){
        this.calculations++;
    }
}
