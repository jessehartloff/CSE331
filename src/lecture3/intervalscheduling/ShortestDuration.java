package lecture3.intervalscheduling;

import java.util.*;

/**
 * Created by jessehartloff on 6/2/15.
 */
public class ShortestDuration {

    public static Set<Interval> generateSolution(IntervalSchedulingProblem intervalSchedulingProblem) {

        // Analyze runtime as an exercise. Not the same runtime as the other 2 algorithms
        // There's very likely a more efficient algorithm in terms of runtime. Can probably get to O(nlogn)

        Set<Interval> scheduledTasks = new HashSet<>();
        List<Interval> intervalList = new ArrayList<>();
        intervalList.addAll(intervalSchedulingProblem.getIntervals());


        Collections.sort(intervalList, new DurationComparator());


        for (Interval interval : intervalList) {
            boolean conflict = false;
            for(Interval scheduledInterval : scheduledTasks){
                if(interval.overlapsWith(scheduledInterval)){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                scheduledTasks.add(interval);
            }
        }

        return scheduledTasks;
    }


    private static class DurationComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.getEndTime() - o1.getStartTime()) - (o2.getEndTime() - o2.getEndTime());
        }
    }

}
