package lecture9;

import java.util.List;

/**
 * Created by jessehartloff on 6/9/15.
 */
public class SelectionSort {


    public static List<Integer> selectionSort(List<Integer> theInts) {

        int numberOfElements = theInts.size();

        for (int i = 0; i < numberOfElements; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = i; j < numberOfElements; j++) {
                if(theInts.get(j) < minValue){
                    minValue = theInts.get(j);
                    minIndex = j;
                }
            }

            int temp = theInts.get(i);
            theInts.set(i, minValue);
            theInts.set(minIndex, temp);
        }
        return theInts;

    }


}
