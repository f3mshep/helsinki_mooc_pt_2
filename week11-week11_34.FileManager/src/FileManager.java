
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File myFile = new File(file);
        List<String> text = new ArrayList<String>();
        Scanner reader = new Scanner(myFile);
        while (reader.hasNextLine()){
            text.add(reader.nextLine());
        }
        return text;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        for (String text : texts){
            writer.write(text + "\n");
        }
        writer.close();
    }
}
