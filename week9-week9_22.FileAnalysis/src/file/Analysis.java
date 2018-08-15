package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;
    // private Scanner reader;

    public Analysis(File file) throws Exception {
        this.file = file;

    }

    public int lines() throws Exception{
        Scanner reader = new Scanner(file);
        int count = 0;
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            count++;
        }
        return count;
    }

    public int characters() throws Exception{
        Scanner reader = new Scanner(file);
        int count = 0;
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            // line breaks should be counted as characters
            // thus we increment here for the removed linebreak
            count++;
            count += line.length();
        }
        return count;
    }


}
