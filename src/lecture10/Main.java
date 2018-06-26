package lecture10;

import javafx.util.Pair;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class Main {

    public static void main(String[] args) {
        int n= 1000;
        ClosestPairOfPointsProblem problem = new ClosestPairOfPointsProblem(n);
//        System.out.println(problem);

        long startTime = System.currentTimeMillis();
        Pair<Point, Point> solution = BruteForceClosestPairAlgorithm.computeClosestPair(problem);
        long bruteForceTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Pair<Point, Point> solution2 = DNCClosestPairAlgorithm.computeClosestPair(problem);
        long dncTime = System.currentTimeMillis() - startTime;

        System.out.println();
        System.out.println("Brute force solution");
        System.out.println(solution.getKey() + " " + solution.getValue());

        System.out.println();
        System.out.println("Divide and Conquer solution");
        System.out.println(solution2.getKey() + " " + solution2.getValue());


        System.out.println();
        System.out.println("brute force ran in " + bruteForceTime + "ms");
        System.out.println("Divide and Conquer ran in " + dncTime + "ms");

    }

}
