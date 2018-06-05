package lecture3.minimizemaximumlateness;

import java.util.*;

/**
 * Created by jessehartloff on 6/19/15.
 */
public class EarliestDeadlineAlgorithm {

    public static List<Task> generateSolution(MinimizeMaximumLatenessProblem minimizeMaximumLatenessProblem) {

        Set<Task> tasks = minimizeMaximumLatenessProblem.getTasks();
//        int n = tasks.size();
        List<Task> taskSchedule = new ArrayList<>(tasks);

        Collections.sort(taskSchedule, new DeadlineComparator());

        return taskSchedule;
    }

    public static class DeadlineComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getDeadline() - o2.getDeadline();
        }
    }

}
