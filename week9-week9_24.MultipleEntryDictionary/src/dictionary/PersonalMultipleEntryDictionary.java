package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();

    @Override
    public void add(String word, String entry) {
        Set<String> entries =  dictionary.get(word);
        if (entries == null) {
            dictionary.put(word, new HashSet<String>());
            entries = dictionary.get(word);
        }
        entries.add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        Set<String> entries = dictionary.get(word);
        return entries;
    }

    @Override
    public void remove(String word) {
        dictionary.remove(word);
    }
}
