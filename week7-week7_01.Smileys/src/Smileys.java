
public class Smileys {

    private static void printWithSmileys(String input){
        int totalLen = input.length();
        String midLine;
        totalLen += isEven(totalLen) ? 2 : 3;
        String smileyLine = smileyLine(totalLen);
        if (isEven(input.length())){
            midLine = ":) " + input + " :)";
        } else {
            midLine = ":) " + input + "  :)";
        }
        System.out.print(smileyLine + "\n");
        System.out.print(midLine + "\n");
        System.out.print(smileyLine+ "\n");
    }


    private static String smileyLine(int num){
        int i = 0;
        String str = "";
        int max = (num / 2) + 2;
        while (i < max){
            str += ":)";
            i++;
        }
        return str;
    }

    private static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        // Test your method at least with the following
//        printWithSmileys("Method");
//        printWithSmileys("Beerbottle");
//        printWithSmileys("Interface");
        printWithSmileys("Matti");
    }

}
