package lecture4.search;

import graphs.CSEEdge;
import graphs.CSEVertex;
import graphs.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class DFS {

    public static void depthFirstSearch(Graph graph, CSEVertex startNode) {

        Graph dfsTree = new Graph();
        Map<Integer, Set<CSEEdge>> adjacencyList = graph.getOutgoingAdjacencyList();
        int startID = startNode.getID();

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startID);
        visited.add(startID);
        dfsTree.addVertex(startID);
//        int previousNode = startID;

        recursiveDFS(dfsTree, adjacencyList, visited, stack);

        System.out.println("\nDFS Tree");
        System.out.println(dfsTree);
    }

    private static void recursiveDFS(Graph dfsTree,
                                     Map<Integer, Set<CSEEdge>> adjacencyList,
                                     Set<Integer> visited,
                                     Stack<Integer> stack){

        if(stack.isEmpty()){
            return;
        }else{

        }

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            System.out.println("Exploring node " + currentNode);
            Set<CSEEdge> connected = adjacencyList.get(currentNode);
            for (CSEEdge edgeToCheck : connected) {
                int nodeToCheck = edgeToCheck.getDestination();
                if (visited.contains(nodeToCheck)) {
                    continue;
                } else {
                    visited.add(nodeToCheck);
                    stack.push(nodeToCheck);
                    dfsTree.addVertex(nodeToCheck);
                    dfsTree.addEdge(currentNode, nodeToCheck);
                    System.out.println("added edge (" + currentNode + "," + nodeToCheck + ")");

                    recursiveDFS(dfsTree, adjacencyList, visited, stack);
                }
            }
        }
    }
}




