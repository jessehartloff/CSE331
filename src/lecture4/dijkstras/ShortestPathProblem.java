package lecture4.dijkstras;


import graphs.*;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class ShortestPathProblem {

    private Graph graph;
    private CSEVertex startingNode;

    private static final double DEFAULT_DENSITY = 0.2;
    private static final int MIN_WEIGHT = 1;
    private static final int MAX_WEIGHT = 100;

    public ShortestPathProblem(int n){
        this(n, DEFAULT_DENSITY);
    }

    public ShortestPathProblem(int n, double density){
        graph = Graph.makeWeightedDirectedGraph(n, density, MIN_WEIGHT, MAX_WEIGHT);
        startingNode = graph.getANode();
    }

    public ShortestPathProblem(Graph graph, CSEVertex startNode){
        this.graph = graph;
        this.startingNode = startNode;
    }

    public Graph getGraph(){
        return graph;
    }


    public CSEVertex getStartingNode(){
        return startingNode;
    }

}
