package lecture10;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class ClosestPairOfPointsProblem {

    private Set<Point> points = new HashSet<>();

    public ClosestPairOfPointsProblem(int n){
        for (int i = 0; i < n; i++) {
            points.add(new Point());
        }
    }

    public ClosestPairOfPointsProblem(Set<Point> points){
        this.points = points;
    }

    public Set<Point> getPoints(){
        return points;
    }


    @Override
    public String toString() {
        return "ClosestPairOfPointsProblem{" +
                "points=" + points +
                '}';
    }
}
