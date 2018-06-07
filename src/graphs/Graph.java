package graphs;

import java.util.*;

/**
 * Created by jessehartloff on 5/12/15.
 */
public class Graph {

    private Set<CSEVertex> nodes;
    private Set<CSEEdge> edges;

    private Map<Integer, Set<CSEEdge>> outgoingAdjacencyList;
    private Map<Integer, Set<CSEEdge>> incomingAdjacencyList;
    private int[][] adjacencyMatrix;
    boolean bookKeeping = true;

    private int numberOfNodes;
    private double density;

    private boolean undirected = true;

    private double DEFAULT_DENSITY = 0.3;

    private int minWeight = 1;
    private int maxWeight = 1;


    /**
     * Makes a weighted undirected graph
     * @param numberOfNodes
     * @param density
     * @param minWeight
     * @param maxWeight
     * @return
     */
    public static Graph makeWeightedGraph(int numberOfNodes, double density, int minWeight, int maxWeight){
        Graph graph = new Graph(numberOfNodes, density);
        graph.setMinEdgeWeight(minWeight);
        graph.setMaxEdgeWeight(maxWeight);
        graph.generateGraph();
        return graph;
    }

    /**
     * Makes an undirected unweighted graph
     *
     * @param numberOfNodes
     * @param density
     * @return
     */
    public static Graph makeGraph(int numberOfNodes, double density){
        Graph graph = new Graph(numberOfNodes, density);
        graph.generateGraph();
        return graph;
    }


    /**
     * Makes a directed unweighted graph
     * @param numberOfNodes
     * @return
     */
    public static Graph makeDirectedGraph(int numberOfNodes, double density){
        Graph graph = new Graph(numberOfNodes, density);
        graph.markAsDirected();
        graph.generateGraph();
        return graph;
    }


    public static Graph makeWeightedDirectedGraph(int numberOfNodes, double density, int minWeight, int maxWeight){
        Graph graph = new Graph(numberOfNodes, density);
        graph.setMinEdgeWeight(minWeight);
        graph.setMaxEdgeWeight(maxWeight);
        graph.markAsDirected();
        graph.generateGraph();
        return graph;
    }


    // can use this directly if you don't need adjacency lists or matrix
    public Graph() {
        nodes = new HashSet<>();
        edges = new HashSet<>();
        bookKeeping = false;
    }

    private Graph(int numberOfNodes, double density) {
        this.numberOfNodes = numberOfNodes;
        this.density = density;
        this.adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
        this.incomingAdjacencyList = new HashMap<>(numberOfNodes);
        this.outgoingAdjacencyList = new HashMap<>(numberOfNodes);
        for(int i = 0; i < numberOfNodes; i++){
            this.incomingAdjacencyList.put(i, new HashSet<>());
            this.outgoingAdjacencyList.put(i, new HashSet<>());
        }
    }

    public void addVertex(int id){
        nodes.add(new CSEVertex(id));
        this.numberOfNodes = nodes.size();
        // breaks adjacency matrix
    }

    public void addEdge(int v0, int v1){
        Random random = new Random();
        int weight = random.nextInt(this.maxWeight - this.minWeight + 1) + this.minWeight;
        addEdge(v0, v1, weight);
    }

    public void addEdge(int v0, int v1, int weight){
        CSEEdge newEdge = new CSEEdge(v0, v1, weight);
        edges.add(newEdge);
        if(bookKeeping) {
            outgoingAdjacencyList.get(v0).add(newEdge);
            incomingAdjacencyList.get(v1).add(newEdge);
            adjacencyMatrix[v0][v1] = weight;
        }
    }



    private void generateGraph() {
        nodes = new HashSet<>(numberOfNodes);
        edges = new HashSet<>((int)(numberOfNodes*numberOfNodes*density));
        Random random = new Random();

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CSEVertex(i));
            for (int j = i+1; j < numberOfNodes; j++) {
                if(undirected){
                    if(Math.random() < density) {
                        int edgeWeight = edgeWeight(random);
                        addEdge(i, j, edgeWeight);
                        addEdge(j, i, edgeWeight); //potential issue since this edge is two objects
                    }
                }
                else{ // directed
                    if(Math.random() < density) {
                        addEdge(i, j, edgeWeight(random));
                    }
                    if(Math.random() < density) {
                        addEdge(j, i, edgeWeight(random));
                    }
                }
            }
        }
    }

    private int edgeWeight() {
        return edgeWeight(new Random());
    }

    private int edgeWeight(Random random) {
        return random.nextInt(maxWeight-minWeight +1) + minWeight;
    }

    public void setMinEdgeWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public void setMaxEdgeWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getNumberOfNodes(){
        return numberOfNodes;
    }

    public int getNumberOfEdges(){
        return edges.size();
    }

    public Set<CSEEdge> getEdges(){
        return edges;
    }

    public Map<Integer, Set<CSEEdge>> getOutgoingAdjacencyList(){
        return outgoingAdjacencyList;
//        Map<Integer, Set<CSEEdge>> adjacencyList = new HashMap<Integer, Set<CSEEdge>>(numberOfNodes);
//        for(CSEVertex vertex : this.nodes){
//            adjacencyList.put(vertex.getID(), new HashSet<>());
//        }
//        for(CSEEdge edge : this.edges){
//            adjacencyList.get(edge.getSource()).add(edge);
////            adjacencyList.get(edge.getDestination()).add(edge);
//        }
//        return adjacencyList;
    }


    public Map<Integer, Set<CSEEdge>> getIncomingAdjacencyList(){
        return outgoingAdjacencyList;
//        Map<Integer, Set<CSEEdge>> adjacencyList = new HashMap<Integer, Set<CSEEdge>>(numberOfNodes);
//        for(CSEVertex vertex : this.nodes){
//            adjacencyList.put(vertex.getID(), new HashSet<>());
//        }
//        for(CSEEdge edge : this.edges){
////            adjacencyList.get(edge.getSource()).add(edge);
//            adjacencyList.get(edge.getDestination()).add(edge);
//        }
//        return adjacencyList;
    }

    public int[][] getAdjacencyMatrix(){
        return adjacencyMatrix;
//        int[][] adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
//        for(CSEEdge edge : edges){
//            adjacencyMatrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
//            adjacencyMatrix[edge.getDestination()][edge.getSource()] = edge.getWeight();
//        }
//        return adjacencyMatrix;
    }

    private void markAsDirected(){
        undirected = false;
    }

    // Always returns the same node
    public CSEVertex getANode() {
        return nodes.iterator().next();
    }


    @Override
    public String toString() {
        return "nodes=" + nodes +
                "\nedges=" + edges +
                "\nnumberOfNodes=" + numberOfNodes +
                "\ndensity=" + density;
    }

}
