package lecture7;

import lecture3.intervalscheduling.Interval;

import java.util.*;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class WeightedIntervalScheduler {

    public static List<WeightedInterval> computeSchedule(WeightedIntervalSchedulingProblem problem){
        List<WeightedInterval> intervals = new ArrayList<>(problem.getIntervals());
        List<WeightedInterval> intervalsByStartTime = new ArrayList<>(problem.getIntervals());
        int n = intervals.size();
        List<WeightedInterval> schedule = new ArrayList<>(n);

        Collections.sort(intervals, new WeightedEndTimeComparator());
        Collections.sort(intervalsByStartTime, new Interval.StartTimeComparator());

        for (int i = 0; i < n; i++) {
            intervals.get(i).setId(i);
        }

        int[] latestNonConflict = new int[n]; // p(i)
        int[] optimalScheduleWeight = new int[n]; // OPT(i)
        boolean[] inOptimal = new boolean[n]; // bookkeeping to track optimal schedule

        Arrays.fill(latestNonConflict, -1);
        optimalScheduleWeight[0] = intervals.get(0).getWeight();
        inOptimal[0] = true;


        //compute latestNonConflict: p(i) - O(n^2) time implementation
//        for (int i = 1; i < n; i++) {
//            for (int j = i-1; j >= 0 ; j--) {
//                if(intervals.get(j).getEndTime() <= intervals.get(i).getStartTime()){
//                    latestNonConflict[i] = j;
//                    break;
//                }
//            }
//        }


        //compute latestNonConflict: p(i) - O(n) time implementation
        int endTimeIndex = n-2;
        int startTimeIndex = n-1;

        while(startTimeIndex >= 0 && endTimeIndex != -1){
            if(intervalsByStartTime.get(startTimeIndex).getStartTime() >= intervals.get(endTimeIndex).getEndTime()){
                //no conflict
                latestNonConflict[intervalsByStartTime.get(startTimeIndex).getId()] = endTimeIndex;
                startTimeIndex--;
            }else{
                endTimeIndex--;
            }
        }



        //compute optimalScheduleWeight: OPT(i)
        for (int i = 1; i < n; i++) {
            int weightWithInterval = latestNonConflict[i] != -1 ?
                    optimalScheduleWeight[latestNonConflict[i]] + intervals.get(i).getWeight() :
                    intervals.get(i).getWeight();
            int weightWithoutInterval = optimalScheduleWeight[i-1];

            if(weightWithInterval > weightWithoutInterval){
                optimalScheduleWeight[i] = weightWithInterval;
                inOptimal[i] = true;
            }else{
                optimalScheduleWeight[i] = weightWithoutInterval;
                inOptimal[i] = false;
            }
        }


        //extract schedule from bookkeeping
        for(int i = n-1; i>=0;){
            if(!inOptimal[i]){
                i--;
            }else {
                schedule.add(intervals.get(i));
                i = latestNonConflict[i];
            }
        }
        Collections.reverse(schedule);

        return schedule;
    }


    private static class WeightedEndTimeComparator implements Comparator<WeightedInterval> {
        @Override
        public int compare(WeightedInterval o1, WeightedInterval o2) {
            return o1.getEndTime() - o2.getEndTime();
        }
    }

}
