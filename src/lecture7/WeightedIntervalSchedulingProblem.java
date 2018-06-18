package lecture7;


import lecture3.intervalscheduling.Interval;

import java.util.*;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class WeightedIntervalSchedulingProblem {

    private Set<WeightedInterval> intervals;
    private int n;

    public WeightedIntervalSchedulingProblem(int n){
        this.n = n;
        this.intervals = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            intervals.add(new WeightedInterval());
        }
    }

    public Set<WeightedInterval> getIntervals(){
        return intervals;
    }



    public boolean validateSolution(List<WeightedInterval> solutionSet){
        intervals.addAll(solutionSet);
        if(intervals.size() != n){
            throw new RuntimeException("Broke the interval set checking a solution");
        }

        List<Interval> solutionList = new ArrayList<Interval>();
        solutionList.addAll(solutionSet);
        Collections.sort(solutionList, new Interval.StartTimeComparator());

        int currentEndTime = 0;
        for(Interval interval : solutionList){
            if(interval.getStartTime() < currentEndTime){
                return false;
            }
            currentEndTime = interval.getEndTime();
        }
        return true;
    }


    public static int getScheduleWeight(List<WeightedInterval> solutionSet){
        int weight = 0;
        for(WeightedInterval interval : solutionSet){
            weight += interval.getWeight();
        }
        return weight;
    }


    @Override
    public String toString() {
        return "intervals=" + intervals;
    }
}
