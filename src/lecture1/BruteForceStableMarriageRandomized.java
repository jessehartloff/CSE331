package lecture1;


public class BruteForceStableMarriageRandomized implements StableMatchingAlgorithm{

    @Override
    public void execute(StableMarriageProblem stableMarriageProblem) {

        int size = stableMarriageProblem.getSize();
        int attempts = 0;

        while (!stableMarriageProblem.isStable()) {

            // clear all engagements
            for(Person woman : stableMarriageProblem.getWomen()) {
                woman.setCurrentlyEngaged(-1);
            }
            for(Person man : stableMarriageProblem.getMen()) {
                man.setCurrentlyEngaged(-1);
            }

            // assign random engagements
            for(Person woman : stableMarriageProblem.getWomen()) {
                while (!woman.isEngaged()) {
                    int randomManIndex = randomIndex(size);
                    Person man = stableMarriageProblem.getMen().get(randomManIndex);
                    if (!man.isEngaged()) {
                        woman.setCurrentlyEngaged(randomManIndex);
                        man.setCurrentlyEngaged(woman.getID());
                    }
                }
            }
            attempts++;
        }

        System.out.println("Brute Force stable after " + attempts + " attempts\n");
    }

    private int randomIndex(int size){
        return (int) (Math.random() * size);
    }
}
