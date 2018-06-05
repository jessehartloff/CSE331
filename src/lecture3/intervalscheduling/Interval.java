package lecture3.intervalscheduling;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by jessehartloff on 6/2/15.
 */
public class Interval {


    private int startTime;
    private int endTime;

    private static final int THE_END_OF_TIME = 10000;
    private static final double DURATION_MEAN = 200;
    private static final double DURATION_SD = 25;



    public Interval(){
        setRandom();
    }

    public Interval(int startTime, int endTime){

        if(startTime >= endTime){
            System.out.println("You get a random interval");
            setRandom();
        }else {
            setStartTime(startTime);
            setEndTime(endTime);
        }
    }


    private void setRandom(){
        //set the start time uniformly at random
        //end time based on a normally distributed duration

        int startTime = (int) (Math.random()*(THE_END_OF_TIME)); // start time ranges from 0 to (THE_END_OF_TIME - 1)

        Random random = new Random();
        int duration = (int) ((random.nextGaussian() * DURATION_SD) + DURATION_MEAN);
        duration = duration < 1 ? 1 : duration;

        int endTime = startTime + duration;
        endTime = endTime > THE_END_OF_TIME ? THE_END_OF_TIME : endTime;

        setStartTime(startTime);
        setEndTime(endTime);
//        System.out.println(this);
    }

    public boolean overlapsWith(Interval otherInterval){
        return ( this.getStartTime() < otherInterval.getEndTime() && this.getEndTime() > otherInterval.getStartTime() ) ||
                ( otherInterval.getStartTime() < this.getEndTime() && otherInterval.getEndTime() > this.getStartTime() );
    }

    public static class StartTimeComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.getStartTime() - o2.getStartTime();
        }
    }



    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[" + startTime +
                ", " + endTime +
                ")";
    }
}
