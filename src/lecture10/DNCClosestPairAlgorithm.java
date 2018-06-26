package lecture10;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class DNCClosestPairAlgorithm {

    public static Pair<Point, Point> computeClosestPair(ClosestPairOfPointsProblem problem){

        Set<Point> points = problem.getPoints();
        Pair<Point, Point> closestPoints = null;

        List<Point> xSorted = new ArrayList<>(points);
        Collections.sort(xSorted, new compareX());

        List<Point> ySorted = new ArrayList<>(points);
        Collections.sort(ySorted, new compareY());

        closestPoints = recursiveClosestPair(xSorted, ySorted);

        return closestPoints;
    }


    private static Pair<Point, Point> recursiveClosestPair(List<Point> xSorted, List<Point> ySorted){

        int n = xSorted.size();

        //base case
        if(n < 4){
            //brute force it
            return BruteForceClosestPairAlgorithm.computeClosestPair(
                    new ClosestPairOfPointsProblem(new HashSet<>(xSorted)));
        }

        Pair<Point, Point> closestPair = null;

        //recursion


        //-split

        // Q_x
        List<Point> firstXSorted = xSorted.subList(0,n/2);
        // R_x
        List<Point> secondXSorted = xSorted.subList(n/2,n);

        // Q_y  needs to be populated
        List<Point> firstYSorted = new ArrayList<>(n/2);
        // R_y  needs to be populated
        List<Point> secondYSorted = new ArrayList<>(n/2);

        // x^*
        double centerX = 0.5*(firstXSorted.get((n/2) - 1).getX() + secondXSorted.get(0).getX());

        // Populate Q_y and R_y
        for (int i = 0; i < n; i++) {
            Point currentPoint = ySorted.get(i);
            if(currentPoint.getX() <= centerX) {
                firstYSorted.add(currentPoint);
            }else{
                secondYSorted.add(currentPoint);
            }
        }


        if(firstXSorted.size() != firstYSorted.size() || secondXSorted.size() != secondYSorted.size()){
            throw new RuntimeException("Didn't split evenly");
        }

        //-recursive call on Q

        Pair<Point, Point> closestFirstHalf = recursiveClosestPair(firstXSorted, firstYSorted);

        //-recursive call on R

        Pair<Point, Point> closestSecondHalf = recursiveClosestPair(secondXSorted, secondYSorted);



        //-merge Q and R (closest-in-box)

        double firstHalfDelta = closestFirstHalf.getKey().distance(closestFirstHalf.getValue());
        double secondHalfDelta = closestSecondHalf.getKey().distance(closestSecondHalf.getValue());

        double delta = Math.min(firstHalfDelta, secondHalfDelta);

        // build S sorted by y
        List<Point> candidateList = new ArrayList<>(n);
        for(Point point : ySorted){
            if(Math.abs(point.getX() - centerX) <= delta){
                candidateList.add(point);
            }
        }


        int numberOfCandidates = candidateList.size();
        int pointsToCheck = 15;

        // find the closest crossing pair (if closer than delta)
        double newDelta = delta;
        for (int i = 0; i < numberOfCandidates; i++) {
            Point currentPoint = candidateList.get(i);
            for (int j = i+1; j < numberOfCandidates && j <= i+pointsToCheck; j++) {
                Point pointToCheck = candidateList.get(j);
                double currentDistance = currentPoint.distance(pointToCheck);
                if(currentDistance < newDelta){
                    newDelta = currentDistance;
                    closestPair = new Pair<>(currentPoint, pointToCheck);
                }
            }
        }

        // capture the results
        if(newDelta == delta){
            if(firstHalfDelta < secondHalfDelta){
                closestPair = closestFirstHalf;
            }else{
                closestPair = closestSecondHalf;
            }
        }

        return closestPair;
    }



    private static class compareX implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            return o1.getX().compareTo(o2.getX());
        }
    }

    private static class compareY implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            return o1.getY().compareTo(o2.getY());
        }
    }

}
