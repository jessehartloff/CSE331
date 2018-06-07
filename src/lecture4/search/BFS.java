package lecture4.search;

import graphs.CSEEdge;
import graphs.CSEVertex;
import graphs.Graph;

import java.util.*;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class BFS{


    public static void breathFirstSearch(Graph graph, CSEVertex startNode){

        Graph bfsTree = new Graph();
        Map<Integer, Set<CSEEdge>> adjacencyList = graph.getOutgoingAdjacencyList(); // input
        int startID = startNode.getID(); // O(1)

        Set<Integer> visited = new HashSet<>(); // O(1)
        Queue<Integer> queue = new LinkedList<>(); // O(1)

        // all O(1)
        queue.add(startID);
        visited.add(startID);
        bfsTree.addVertex(startID);

        int countIterations = 0;

        while(!queue.isEmpty()){
            countIterations++; // If all nodes are added to the queue, this is O(n)
            int currentNode = queue.remove();

            System.out.println("Exploring node " + currentNode);

            Set<CSEEdge> connected = adjacencyList.get(currentNode);
            for(CSEEdge edgeToCheck : connected){
                countIterations++; // show O(m) runtime of the outer while loop
                int nodeToCheck = edgeToCheck.getDestination();
                if(visited.contains(nodeToCheck)){ // O(1) check
                    continue; //found a cycle!
                }else{
                    // All are O(1) time function calls
                    visited.add(nodeToCheck);
                    queue.add(nodeToCheck);
                    bfsTree.addVertex(nodeToCheck);
                    bfsTree.addEdge(currentNode, nodeToCheck);

                    System.out.println("added edge (" + currentNode + "," + nodeToCheck + ")");
                }
            }
            System.out.println();
        }

        // overall O(n+m) runtime

        System.out.println("BFS Tree");
        System.out.println(bfsTree);
        System.out.println("\nInner loop executed " + countIterations + " times");
        System.out.println("The graph has " + graph.getNumberOfNodes() + " nodes and " + graph.getNumberOfEdges() + " edges");

    }


}
