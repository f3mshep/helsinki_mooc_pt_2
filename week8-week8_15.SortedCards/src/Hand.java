import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public void add(Card card){
        cards.add(card);
    }

    public void print(){
        for (Card card: cards){
            System.out.println(card);
        }
    }

    public void sort(){
        Collections.sort(cards);
    }

    public void sortAgainstSuit(){
        SortAgainstSuitAndValue comparator = new SortAgainstSuitAndValue();
        Collections.sort(cards, comparator);
    }

    @Override
    public int compareTo(Hand hand) {
        return this.totalValue() - hand.totalValue();
    }

    private int totalValue(){
        int value = 0;
        for (Card card: cards){
            value += card.getValue();
            //value += card.getSuit();
        }
        return value;
    }
}
