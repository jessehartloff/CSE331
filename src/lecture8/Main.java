package lecture8;


import lecture4.dijkstras.DijkstrasAlgorithm;
import lecture4.dijkstras.ShortestPathProblem;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class Main{

    public static void main(String[] args){
        while(!runTest());
    }


    public static boolean runTest(){
        int n = 8;
        ShortestPathWithNegativesProblem problem = new ShortestPathWithNegativesProblem(n);
        System.out.println(problem.getGraph());


        System.out.println();
        System.out.println("Dijkstra's Paths:");
        int[] dijkstraDistances = DijkstrasAlgorithm.computeSolution(new ShortestPathProblem(problem.getGraph(), problem.getStartNode()));


        System.out.println();
        System.out.println("Bellman-Ford Paths:");
        int[] distances = BellmanFord.computeDistances(problem);
        if(distances[0] < 0){
            // negative cycle
            return false;
        }

        System.out.println();
        System.out.println();
        System.out.println("Dijkstra's solution:");
        DijkstrasAlgorithm.printDistances(dijkstraDistances);

        System.out.println();
        System.out.println("Bellman-Ford solution:");
        DijkstrasAlgorithm.printDistances(distances);

        return true;
    }
}
