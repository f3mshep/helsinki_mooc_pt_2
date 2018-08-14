public class CD implements ToBeStored {

    private String artist, title;
    private int published;
    private final double weight = 0.1;



    public CD(String artist, String title, int published) {
        this.artist = artist;
        this.title = title;
        this.published = published;
    }

    public double weight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.published + ")";
    }
}
