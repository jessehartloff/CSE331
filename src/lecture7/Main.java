package lecture7;

import java.util.List;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class Main {

    public static void main(String[] args) {

        int n=10;
        WeightedIntervalSchedulingProblem problem = new WeightedIntervalSchedulingProblem(n);

        System.out.println(problem); // print when sorted in algo
        System.out.println();

        List<WeightedInterval> schedule = WeightedIntervalScheduler.computeSchedule(problem);

        System.out.println(schedule);
        System.out.println();
        System.out.println("Schedule weight: " + WeightedIntervalSchedulingProblem.getScheduleWeight(schedule));

        System.out.println();
        if(!problem.validateSolution(schedule)){
            System.out.println("Schedule is invalid");
        }


    }
}
