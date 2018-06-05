package lecture3.minimizemaximumlateness;

import java.util.*;

/**
 * Created by jessehartloff on 6/19/15.
 */
public class ShortestDurationAlgorithm {

    public static List<Task> generateSolution(MinimizeMaximumLatenessProblem minimizeMaximumLatenessProblem) {

        Set<Task> tasks = minimizeMaximumLatenessProblem.getTasks();
//        int n = tasks.size();
        List<Task> taskSchedule = new ArrayList<>(tasks);

        Collections.sort(taskSchedule, new DurationComparator());

        return taskSchedule;
    }


    public static class DurationComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getDuration() - o2.getDuration();
        }
    }

}
