package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();

    @Override
    public void add(String word, String entry) {
        dictionary.get()
    }

    @Override
    public Set<String> translate(String word) {
        return null;
    }

    @Override
    public void remove(String word) {

    }
}
