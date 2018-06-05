package lecture3.intervalscheduling;

import java.util.Set;

/**
 * Created by jessehartloff on 6/2/15.
 */
public class Main {

    public static void main(String[] args) {

        int n = 100;
        System.out.println("n=" + n);
        System.out.println();

        IntervalSchedulingProblem intervalSchedulingProblem = new IntervalSchedulingProblem(n);
        System.out.println(intervalSchedulingProblem);

        Set<Interval> earliestStartTimeSolution = EarliestStartTime.generateSolution(intervalSchedulingProblem);
        if(!intervalSchedulingProblem.validateSolution(earliestStartTimeSolution)){
            System.out.println("earliestStartTimeSolution is invalid");
        }

        Set<Interval> shortestDurationSolution = ShortestDuration.generateSolution(intervalSchedulingProblem);
        if(!intervalSchedulingProblem.validateSolution(shortestDurationSolution)){
            System.out.println("shortestDurationSolution is invalid");
        }

        Set<Interval> earliestEndTimeSolution = EarliestEndTime.generateSolution(intervalSchedulingProblem);
        if(!intervalSchedulingProblem.validateSolution(earliestEndTimeSolution)){
            System.out.println("earliestStartTimeSolution is invalid");
        }

        System.out.println();
        System.out.println(earliestStartTimeSolution.size() + " intervals scheduled by earliest start time");
        System.out.println(shortestDurationSolution.size() + " intervals scheduled by shortest duration");
        System.out.println(earliestEndTimeSolution.size() + " intervals scheduled by earliest end time");


    }

}
