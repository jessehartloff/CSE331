package lecture8;


import graphs.CSEVertex;
import graphs.Graph;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class ShortestPathWithNegativesProblem {

    private static final double DEFAULT_DENSITY = 0.5;
    private static final int MIN_WEIGHT = -50;
    private static final int MAX_WEIGHT = 100;
    private int n;
    private Graph graph;
    private CSEVertex startNode;

    // does not guarantee there are no negative weight cycles
    public ShortestPathWithNegativesProblem(int n){
        this.n = n;
        this.graph = Graph.makeWeightedDirectedGraph(n, DEFAULT_DENSITY, MIN_WEIGHT, MAX_WEIGHT);
        startNode = graph.getANode();
    }

    public Graph getGraph(){
        return graph;
    }

    public CSEVertex getStartNode(){
        return startNode;
    }

}
