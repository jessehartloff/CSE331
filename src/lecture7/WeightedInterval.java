package lecture7;

import lecture3.intervalscheduling.Interval;

import java.util.Random;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class WeightedInterval extends Interval{

    private int id;
    private int weight;

    private static final int MAX_INTERVAL_WEIGHT = 50;

    public WeightedInterval(){
        setRandomWeight();
    }

    private void setRandomWeight(){
        Random random = new Random();
        this.weight = random.nextInt(MAX_INTERVAL_WEIGHT);
    }

    public int getWeight(){
        return weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + this.getStartTime() + "," + this.getEndTime() + "):" + weight + " ";
    }
}
