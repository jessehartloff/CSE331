package lecture10;

import javafx.util.Pair;

import java.util.Set;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class BruteForceClosestPairAlgorithm {


    public static Pair<Point, Point> computeClosestPair(ClosestPairOfPointsProblem problem){

        Pair<Point, Point> closestPoints = null;
        Set<Point> allPoints = problem.getPoints();

        double minDistance = Double.POSITIVE_INFINITY;

        for(Point point1 : allPoints){
            for(Point point2 : allPoints){
                if(point1 != point2){
                    double distance = point1.distance(point2);
                    if(distance < minDistance){
                        minDistance = distance;
                        closestPoints = new Pair<>(point1, point2);
                    }
                }
            }
        }

        return closestPoints;
    }

}
