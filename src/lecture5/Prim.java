package lecture5;

import graphs.CSEEdge;
import graphs.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class Prim {


    public static Graph computeMST(MinimumSpanningTreeProblem problem){

        // *non-optimal asymptotic runtime

        // can assume the graph in undirected
        Graph inputGraph = problem.getGraph();
        Graph minimumSpanningTree = new Graph();

        Set<CSEEdge> edges = new HashSet<>(inputGraph.getEdges());
        Map<Integer, Set<CSEEdge>> adjacencyList = inputGraph.getOutgoingAdjacencyList();

        //start at random node and run simplified dijkstra
        int startNode = inputGraph.getANode().getID();
        Set<Integer> set = new TreeSet<>();

        int n = inputGraph.getNumberOfNodes();

        Set<Integer> explored = new HashSet<>();
        int[] lowestEdgeCost = new int[n];
        int[] previousNode = new int[n];


        //initialize
        for (int i = 0; i < n; i++) {
            lowestEdgeCost[i] = Integer.MAX_VALUE;
            previousNode[i] = -1;
        }

        lowestEdgeCost[startNode] = 0;


        while(true){

            //find minimum crossing edge
            int minEdgeCost = Integer.MAX_VALUE;
            int nodeID = -1;

            for (int i = 0; i < n; i++) {
                if(lowestEdgeCost[i] < minEdgeCost){
                    minEdgeCost = lowestEdgeCost[i];
                    nodeID = i;
                }
            }

            if(nodeID == -1){
                break;
            }


            if(previousNode[nodeID] != -1) {
                minimumSpanningTree.addEdge(nodeID, previousNode[nodeID], minEdgeCost);
            }


            lowestEdgeCost[nodeID] = Integer.MAX_VALUE; // make sure this node doesn't have the minimum crossing edge again
            explored.add(nodeID);

            for(CSEEdge edgeToCheck : adjacencyList.get(nodeID)){
                int destinationNode = edgeToCheck.getDestination();
                if(explored.contains(destinationNode)){
                    continue;
                }

                int edgeWeightFound = edgeToCheck.getWeight();
                int oldDistance = lowestEdgeCost[destinationNode];
                if(edgeWeightFound < oldDistance){
                    lowestEdgeCost[destinationNode] = edgeWeightFound;
                    previousNode[destinationNode] = nodeID;
                }
            }

        }

        return minimumSpanningTree;
    }


}
