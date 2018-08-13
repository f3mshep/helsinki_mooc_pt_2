import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private final HashMap<String, String> dictionary = new HashMap<String, String>();

    public String translate(String word){
        return dictionary.get(word);
    }

    public void add(String word, String translation){
        dictionary.put(word, translation);
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> pairs = new ArrayList<String>();
        for (String key : dictionary.keySet()){
            pairs.add(key + " = " + dictionary.get(key));
        }
        return pairs;
    }

}
