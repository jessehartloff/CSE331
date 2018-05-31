package lecture1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Person {

    private int id;
    private List<Integer> preferences; // Preference list as defined in lecture
    private List<Integer> preferencesIndexedByPerson; //Data structure for fast lookup of a potential spouses preference
    private int currentlyEngaged = -1;

    public Person(int id, int size){
        this.id = id;
        preferences = new ArrayList<>(size);
        preferencesIndexedByPerson = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            preferences.add(i);
            preferencesIndexedByPerson.add(-1);
        }

        Collections.shuffle(preferences);

        for (int i = 0; i < size; i++) {
            preferencesIndexedByPerson.set(preferences.get(i), i);
        }

    }


    public int getID() {
        return id;
    }

    public boolean isEngaged(){
        return currentlyEngaged != -1;
    }

    public int getPreferenceOfSpouse() {
        if(currentlyEngaged == -1){
            return Integer.MAX_VALUE;
        }
        return preferencesIndexedByPerson.get(currentlyEngaged);
    }

    public int getPreference(int id) {
        return preferencesIndexedByPerson.get(id);
    }

    public int getPreferenceByOrder(int index) {
        return preferences.get(index);
    }

    public int getCurrentlyEngaged() {
        return currentlyEngaged;
    }

    public void setCurrentlyEngaged(int currentlyEngaged) {
        this.currentlyEngaged = currentlyEngaged;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", preferences=" + preferences +
                ", currentlyEngaged=" + currentlyEngaged +
                "}\n";
    }
}
