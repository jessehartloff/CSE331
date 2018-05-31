package lecture1;


public class Main{

    public static void main(String[] args){
        testGaleShapely(5);
    }


    public static void testBruteForce(int inputSize){
        StableMarriageProblem problem = new StableMarriageProblem(inputSize);
        StableMatchingAlgorithm bruteForce = new BruteForceStableMarriageRandomized();
        bruteForce.execute(problem);
//        System.out.println(problem);
//        problem.printMatches();
    }


    public static void testGaleShapely(int inputSize){
        StableMarriageProblem problem = new StableMarriageProblem(inputSize);
        System.out.println(problem);
        StableMatchingAlgorithm galeShapely = new GaleShapelyAlgorithm();
        galeShapely.execute(problem);
        System.out.println(problem);
        problem.printMatches();
    }

}
