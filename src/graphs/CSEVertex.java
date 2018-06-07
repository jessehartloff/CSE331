package graphs;

/**
 * Created by jessehartloff on 5/12/15.
 */
public class CSEVertex {

    private int id;

    public CSEVertex(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }

    @Override
    public String toString() {
        return "" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CSEVertex cseVertex = (CSEVertex) o;

        return id == cseVertex.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
