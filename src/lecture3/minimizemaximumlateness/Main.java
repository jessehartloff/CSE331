package lecture3.minimizemaximumlateness;

import java.util.List;

/**
 * Created by jessehartloff on 6/19/15.
 */
public class Main {

    public static void main(String[] args) {

        int n = 50;
        System.out.println("n=" + n);
        System.out.println();

        MinimizeMaximumLatenessProblem minimizeMaximumLatenessProblem = new MinimizeMaximumLatenessProblem(n);
        System.out.println(minimizeMaximumLatenessProblem);

        List<Task> earliestDeadlineSolution = EarliestDeadlineAlgorithm.generateSolution(minimizeMaximumLatenessProblem);
        int earliestDeadlineMaximumLateness = minimizeMaximumLatenessProblem.getMaximumLateness(earliestDeadlineSolution);

        List<Task> shortestDurationSolution = ShortestDurationAlgorithm.generateSolution(minimizeMaximumLatenessProblem);
        int shortestDurationMaximumLateness = minimizeMaximumLatenessProblem.getMaximumLateness(shortestDurationSolution);

        System.out.println();
        System.out.println("Earliest Deadline: " + earliestDeadlineSolution);
        System.out.println();
        System.out.println("Shortest Duration: " + shortestDurationSolution);
        System.out.println();
        System.out.println("earliestDeadlineSolution maximum lateness: " + earliestDeadlineMaximumLateness);
        System.out.println("shortestDurationSolution maximum lateness: " + shortestDurationMaximumLateness);

    }

}
