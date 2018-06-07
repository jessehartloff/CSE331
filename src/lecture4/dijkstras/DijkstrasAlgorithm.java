package lecture4.dijkstras;


import graphs.CSEEdge;
import graphs.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jessehartloff on 6/24/15.
 */
public class DijkstrasAlgorithm{


    public static int[] computeSolution(ShortestPathProblem shortestPathProblem){

        //O(mn) implementation

        Graph graph = shortestPathProblem.getGraph();
        Map<Integer, Set<CSEEdge>> outgoingAdjacencyList = graph.getOutgoingAdjacencyList();

        int startNode = shortestPathProblem.getStartingNode().getID();

        Set<Integer> explored = new HashSet<>(graph.getNumberOfNodes());
        int[] distances = new int[graph.getNumberOfNodes()];
        int[] bestKnownDistances = new int[graph.getNumberOfNodes()];
        int[] previousNode = new int[graph.getNumberOfNodes()]; // track shortest path tree

        //initialize
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            bestKnownDistances[i] = Integer.MAX_VALUE;
            previousNode[i] = -1;
        }
        bestKnownDistances[startNode] = 0;


        while(true){

            //find minimum d'
            int minDistance = Integer.MAX_VALUE;
            int nodeID = -1;

            for (int i = 0; i < graph.getNumberOfNodes(); i++) {
                if(bestKnownDistances[i] < minDistance){
                    minDistance = bestKnownDistances[i];
                    nodeID = i;
                }
            }
            if(nodeID == -1){
                break;
            }


            distances[nodeID] = minDistance;
            bestKnownDistances[nodeID] = Integer.MAX_VALUE; // make sure this node doesn't have the minimum d' again
            explored.add(nodeID);

            for(CSEEdge edgeToCheck : outgoingAdjacencyList.get(nodeID)){
                int destinationNode = edgeToCheck.getDestination();
                if(explored.contains(destinationNode)){
                    continue;
                }

                int distanceFound = distances[nodeID] + edgeToCheck.getWeight();
                int oldDistance = bestKnownDistances[destinationNode];
                if(distanceFound < oldDistance){
                    bestKnownDistances[destinationNode] = distanceFound;
                    previousNode[destinationNode] = nodeID;
                }
            }

        }


        DijkstrasAlgorithm.printPath(previousNode);
        return distances;
    }



    public static void printDistances(int[] distances){
        for (int i = 0; i < distances.length; i++) {
            System.out.println("distance to node " + i + " is " + distances[i]);
        }
    }

    public static void printPath(int[] distances){
        for (int i = 0; i < distances.length; i++) {
            System.out.println(distances[i] + " connects to " + i);
        }
    }


}
