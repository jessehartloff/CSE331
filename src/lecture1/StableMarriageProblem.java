package lecture1;

import java.util.ArrayList;
import java.util.List;


public class StableMarriageProblem {

    private int size;
    private List<Person> men;
    private List<Person> women;


    public StableMarriageProblem(int size){

        this.size = size;
        this.men = new ArrayList<Person>(size);
        this.women = new ArrayList<Person>(size);

        for (int i = 0; i < size; i++) {
            men.add(new Person(i, size));
            women.add(new Person(i, size));
        }

    }

    public Person getManByID(int ID){
        Person man = men.get(ID);
        return man;
    }

    public boolean isStable(){

        for(Person man : men){
            for(Person woman : women){
                if(man.getPreference(woman.getID()) < man.getPreferenceOfSpouse() && // If not engaged, this is always false
                        woman.getPreference(man.getID()) < woman.getPreferenceOfSpouse()){
                    return false;
                }
            }
        }

        return true;
    }

    public int getSize() {
        return size;
    }


    public List<Person> getMen() {
        return men;
    }

    public List<Person> getWomen() {
        return women;
    }


    public void printMatches(){
        for(Person woman : women){
            System.out.println("Women " + woman.getID() + " engaged to man " + woman.getCurrentlyEngaged());
        }
    }

    @Override
    public String toString() {
        return "StableMarriageProblem of size: " + size +
                "\nwomen=" + women +
                "\nmen=" + men;
    }
}
