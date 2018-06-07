package lecture4.dijkstras;

/**
 * Created by jessehartloff on 6/24/15.
 */
public class Main {

    public static void main(String[] args) {

        int n=10;
        ShortestPathProblem problem = new ShortestPathProblem(n);

        System.out.println(problem.getGraph());
        System.out.println();

        System.out.println("start node: " + problem.getStartingNode().getID());
        System.out.println();


        long startTime = System.currentTimeMillis();
        int[] distances = DijkstrasAlgorithm.computeSolution(problem);
        long runtime = System.currentTimeMillis() - startTime;

        System.out.println();
        System.out.println();
        DijkstrasAlgorithm.printDistances(distances);

        System.out.println();
        System.out.println();




        System.out.println();
        System.out.println("DijkstrasAlgorithm took: " + runtime + "ms");

    }
}
