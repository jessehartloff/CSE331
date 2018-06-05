package lecture3.intervalscheduling;

import java.util.*;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class IntervalSchedulingProblem {

    private int n;
    private Set<Interval> intervals;

    public IntervalSchedulingProblem(int n){
        this.intervals = new HashSet<>(n);
        this.n = n;
        for (int i = 0; i < n; i++) {
            this.intervals.add(new Interval());
        }
    }


    public Set<Interval> getIntervals(){
        return intervals;
    }


    public boolean validateSolution(Set<Interval> solutionSet){
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


    @Override
    public String toString() {
        return "Intervals = {" + intervals + '}';
    }
}
