import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SkierRound {
    private final int JUDGE_AMOUNT = 5;
    private Skier skier;
    private int roundNumber;
    private int jumpLength;
    private ArrayList<Integer> scores =  new ArrayList<Integer>();

    public SkierRound(Skier skier, int roundNumber) {
        this.skier = skier;
        this.roundNumber = roundNumber;
        doJump();
    }

    public void doJump(){
        this.jumpLength = MyRandom.getRandomNumberInRange(60,120);
        calculateScore();
        skier.addPoints(getScore());
        skier.addJump(this.jumpLength);
    }

    public int getScore(){
        Collections.sort(scores);
        int judgeScore = 0;
        // magic number-y
        for (int i = 1; i < 4; i++) {
            judgeScore += scores.get(i);
        }
        return judgeScore + this.jumpLength;
    }

    @Override
    public String toString() {
        return "  " + skier.getName() + "\n" + "    length: " + this.jumpLength + "\n" + "    judge votes: " + scores.toString();
    }

    private void calculateScore(){

        int i = 0;
        while (i < this.JUDGE_AMOUNT){
            scores.add(MyRandom.getRandomNumberInRange(10,20));
            i++;
        }
    }
}
