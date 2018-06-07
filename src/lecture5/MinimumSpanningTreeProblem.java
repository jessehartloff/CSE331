package lecture5;

import graphs.Graph;

/**
 * Created by jessehartloff on 6/24/15.
 */
public class MinimumSpanningTreeProblem {


    private Graph graph;

    private static final double DEFAULT_DENSITY = 0.4;
    private static final int MIN_WEIGHT = 1;
    private static final int MAX_WEIGHT = 50;

    public MinimumSpanningTreeProblem(int n){
        this(n, DEFAULT_DENSITY);
    }

    public MinimumSpanningTreeProblem(int n, double density){
        graph = Graph.makeWeightedGraph(n, density, MIN_WEIGHT, MAX_WEIGHT);
    }

    public Graph getGraph(){
        return graph;
    }



}
