package graphs;

/**
 * Created by jessehartloff on 5/12/15.
 */
public class CSEEdge {

    private int source;
    private int destination;

    private int weight;

    public CSEEdge(int v0, int v1) {
        this(v0,v1,1);
    }

    public CSEEdge(int v0, int v1, int weight) {
//        source = v0 < v1 ? v0 : v1;
//        destination = v0 < v1 ? v1 : v0;
        source = v0;
        destination = v1;
        this.weight = weight;
    }

    public int getSource(){
        return source;
    }

    public int getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "((" + source +
                "," + destination +
                ")," + weight + ")";
    }

    public int getOtherVertex(int currentNode) {
        if(currentNode == getSource()){
            return getDestination();
        }
        if(currentNode == getDestination()){
            return getSource();
        }
        throw new RuntimeException("Misuse of edges");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CSEEdge cseEdge = (CSEEdge) o;

        if (source != cseEdge.source) return false;
        if (destination != cseEdge.destination) return false;
        return weight == cseEdge.weight;

    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + destination;
        result = 31 * result + weight;
        return result;
    }
}
