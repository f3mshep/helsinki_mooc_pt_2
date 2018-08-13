public class Change {
    private char from, to;

    public Change(char from, char to){
        this.from = from;
        this.to = to;
    }

    public String change(String word){
        return word.replace(from, to);
    }

}
