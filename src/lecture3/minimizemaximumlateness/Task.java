package lecture3.minimizemaximumlateness;

import java.util.Random;

/**
 * Created by jessehartloff on 6/17/15.
 */
public class Task {

    private int duration;
    private int deadline;

    private static final int LATEST_DEADLINE = 1000;
    private static final double DURATION_MEAN = 30;
    private static final double DURATION_SD = 15;



    public Task(){
        setRandom();
    }

    public Task(int duration, int deadline){

        setDuration(duration);
        setDeadline(deadline);

    }


    private void setRandom(){
        //set the deadline uniformly at random
        //duration is normally distributed

        int deadline = (int)(Math.random()*(LATEST_DEADLINE)); // deadline ranges from 0 to (LATEST_DEADLINE - 1)
        Random random = new Random();

        int duration = (int) ((random.nextGaussian() * DURATION_SD) + DURATION_MEAN);
        duration = duration < 1 ? 1 : duration;

        setDeadline(deadline);
        setDuration(duration);
//        System.out.println(this);
        //if end time past the end of time, it equals the end of time
    }

//    public boolean overlapsWith(Interval otherInterval){
//        return ( this.getDeadline() < otherInterval.getEndTime() && this.getEndTime() > otherInterval.getDeadline() ) ||
//                ( otherInterval.getDeadline() < this.getEndTime() && otherInterval.getEndTime() > this.getDeadline() );
//    }





    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "(" + duration +
                ", " + deadline +
                ")";
    }


}
