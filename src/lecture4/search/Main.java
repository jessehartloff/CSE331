package lecture4.search;

import graphs.Graph;

/**
 * Created by jessehartloff on 6/4/15.
 */
public class Main {

    public static void main(String[] args) {

        int n=10;
        double density=0.5;

        Graph graph = Graph.makeGraph(n, density);

        System.out.println(graph);

        System.out.println();
        System.out.println("** Running BFS **");

        BFS.breathFirstSearch(graph, graph.getANode());

        System.out.println();
        System.out.println("** Running DFS **");

        DFS.depthFirstSearch(graph, graph.getANode());

        System.out.println();
        System.out.println();

        System.out.println(graph.getANode());



    }

}
