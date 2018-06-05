package lecture1;

import java.util.HashSet;
import java.util.Set;


public class GaleShapelyAlgorithm implements StableMatchingAlgorithm {

    @Override
    public void execute(StableMarriageProblem stableMarriageProblem) {

        int[] nextProposals = new int[stableMarriageProblem.getSize()];

        int numberOfProposals = 0;

        Set<Person> singleWomen = new HashSet<>();
        singleWomen.addAll(stableMarriageProblem.getWomen());

        while(!singleWomen.isEmpty()) {
            numberOfProposals++;
            Person currentWoman = singleWomen.iterator().next();

            int proposerID = currentWoman.getID();
            int proposeTo = currentWoman.getPreferenceByOrder(nextProposals[proposerID]++);
            Person man = stableMarriageProblem.getManByID(proposeTo);

//            System.out.print("Woman " + proposerID + " proposing to man " + proposeTo + " : ");

            if(man.getCurrentlyEngaged() == -1) {//man free
//                System.out.println("man free, got engaged");
                man.setCurrentlyEngaged(proposerID);
                currentWoman.setCurrentlyEngaged(proposeTo);
                singleWomen.remove(currentWoman);

            }else if(man.getPreference(proposerID) < man.getPreferenceOfSpouse()){//man not free and proposer is better
//                System.out.println("man broke current engagement, got engaged");
                Person previousEngagement = stableMarriageProblem.getWomen().get(man.getCurrentlyEngaged());
                previousEngagement.setCurrentlyEngaged(-1);
                singleWomen.add(previousEngagement);

                man.setCurrentlyEngaged(proposerID);
                currentWoman.setCurrentlyEngaged(proposeTo);
                singleWomen.remove(currentWoman);

            }else{//man not free and proposer is worse
                //nothing happens
//                System.out.println("man rejected, woman still single");
            }
//            System.out.println();
//            stableMarriageProblem.printMatches();
//            System.out.println();
        }
        System.out.println("Gale-Shapely executed in " + numberOfProposals + " proposals\n");
    }


}
