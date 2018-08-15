package wordinspection;

import java.io.File;
import java.util.*;

public class WordInspection {

    private File file;

    public WordInspection(File file) throws Exception {
        this.file = file;
    }

    public int wordCount() throws Exception{
        int count = 0;
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            // trim extra spaces, split on a regex pattern, then count the length of the resulting Array
            count += line.trim().split("\\s+").length;
        }
        return count;
    }

    public List<String> wordsContainingZ() throws Exception{
        ArrayList<String> matches = new ArrayList<String>();
        ArrayList<String> words = getWords();
        for (String word:words){
            if (word.contains("z")) matches.add(word);
        }
        return matches;
    }

    public List<String> wordsEndingInL() throws Exception{
        ArrayList<String> matches = new ArrayList<String>();
        ArrayList<String> words = getWords();
        for (String word:words){
            int lastIndex = word.length() - 1;
            if (word.charAt(lastIndex) == 'l') matches.add(word);
        }
        return matches;
    }

    public List<String> wordsWhichContainAllVowels() throws Exception{
        ArrayList<String> matches = new ArrayList<String>();
        List<Character> vowels = Arrays.asList('a','e','i','o','u','y','ä','ö');
        ArrayList<String> words = getWords();
        for (String word:words){
            if (wordContainsAllVowels(word)) matches.add(word);
        }
        return matches;
    }

    public List<String> palindromes() throws Exception{
        ArrayList<String> matches = new ArrayList<String>();
        ArrayList<String> words = getWords();
        for (String word:words){
            if (reverse(word).equals(word)) matches.add(word);
        }
        return matches;
    }

    private boolean wordContainsAllVowels(String word){
        Set<Character> vowelSet = stringToSet("aeiouyäö");
        Set<Character> wordSet = stringToSet(word);
        return wordSet.containsAll(vowelSet);
    }

    public static Set<Character> stringToSet(String s) {
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private ArrayList<String> getWords() throws Exception{
        Scanner reader = new Scanner(file);
        ArrayList<String> words = new ArrayList<String>();
        while (reader.hasNextLine()){
            Scanner check = new Scanner(reader.nextLine());
            while(check.hasNext()){
                    words.add(check.nextLine());
                }

        }
        return words;
    }

    private String reverse(String a) {
        int j = a.length();
        char[] newWord = new char[j];
        for (int i = 0; i < a.length(); i++) {
            newWord[--j] = a.charAt(i);
        }
        return new String(newWord);
    }
}
