package lecture8;

import graphs.CSEEdge;
import graphs.Graph;
import lecture4.dijkstras.DijkstrasAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class BellmanFord {

    public static int[] computeDistances(ShortestPathWithNegativesProblem problem){

        Graph graph = problem.getGraph();
        int n = graph.getNumberOfNodes();

        Set<CSEEdge> edges = new HashSet<>(graph.getEdges());

        int[] distances = new int[n];
        int[] previousNode = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previousNode, -1);

        distances[problem.getStartNode().getID()] = 0;
        int countIterations = 0;
        boolean updated = true;

        while(updated) {
            if(countIterations > n+10){
                System.out.println();
                System.out.println("Found negative loop");
                break;
            }
            updated = false;
            countIterations++;
            for (CSEEdge edge : edges) {
                if(distances[edge.getSource()] == Integer.MAX_VALUE){
                    continue;
                }
                int foundWeight = edge.getWeight() + distances[edge.getSource()];
                int oldWeight = distances[edge.getDestination()];
                if(foundWeight < oldWeight){
                    // better path found
                    updated = true;
                    distances[edge.getDestination()] = foundWeight;
                    previousNode[edge.getDestination()] = edge.getSource();
                }
            }
        }

        System.out.println();
        System.out.println("Ran for " + countIterations + " iterations");
        DijkstrasAlgorithm.printPath(previousNode);
        return distances;
    }

}
