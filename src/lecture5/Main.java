package lecture5;

import graphs.Graph;

/**
 * Created by jessehartloff on 6/24/15.
 */
public class Main {


    public static void main(String[] args) {

        int n = 10;
        MinimumSpanningTreeProblem problem = new MinimumSpanningTreeProblem(n);

        System.out.println(problem.getGraph());
        System.out.println();
        System.out.println();


        Graph minimumSpanningTree = Prim.computeMST(problem);
        System.out.println("MST");
        System.out.println(minimumSpanningTree);

        System.out.println();
    }



}
