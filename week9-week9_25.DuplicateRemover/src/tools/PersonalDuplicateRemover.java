package tools;

import java.util.*;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Map<String, Integer> words = new HashMap<String, Integer>();
    private int duplicate = 0;


    @Override
    public void add(String characterString) {
        Integer amount = words.get(characterString);
        if (amount == null) {
            this.words.put(characterString, 0);
            amount = 0;
        }
        if (amount > 0) duplicate++;
        words.put(characterString, ++amount);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicate;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> matches = new HashSet<String>();
        for (String word : words.keySet()){
            // int amount = this.words.get(word);
            // if (amount == 1) matches.add(word);
            matches.add(word);
        }
        return matches;
    }

    @Override
    public void empty() {
        words.clear();
        this.duplicate = 0;
    }
}
