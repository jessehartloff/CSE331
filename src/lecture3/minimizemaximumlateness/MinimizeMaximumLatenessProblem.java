package lecture3.minimizemaximumlateness;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jessehartloff on 6/2/15.
 */
public class MinimizeMaximumLatenessProblem {

    private int n;
    private Set<Task> tasks;

    public MinimizeMaximumLatenessProblem(int n){
        this.tasks = new HashSet<>(n);
        this.n = n;
        for (int i = 0; i < n; i++) {
            this.tasks.add(new Task());
        }
    }


    public Set<Task> getTasks(){
        return tasks;
    }


    public int getMaximumLateness(List<Task> solutionSet){

//        tasks.addAll(solutionSet);
        if( (solutionSet.size() != n) || !solutionSet.containsAll(tasks) ){
            throw new RuntimeException("Broke the task set checking a solution");
        }

        int currentEndTime = 0;
        int maximumLateness = 0;

        for(Task task : solutionSet){
            currentEndTime += task.getDuration(); // don't allow idle time
            int lateness = Math.max(currentEndTime - task.getDeadline(), 0);
            maximumLateness = Math.max(maximumLateness, lateness);
        }

        return maximumLateness;
    }


    @Override
    public String toString() {
        return "Tasks = {" + tasks + '}';
    }


}
