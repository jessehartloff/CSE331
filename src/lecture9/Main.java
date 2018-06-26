package lecture9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by jessehartloff on 6/9/15.
 */
public class Main {

    public static void main(String[] args) {

        int numberOfElements = 300000;
        int maxValue = Integer.MAX_VALUE;

        List<Integer> theInts = new ArrayList<>(numberOfElements);

        Random random = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            theInts.add(random.nextInt(maxValue));
        }

//        System.out.println(theInts);
//        System.out.println();


        long startTime;

//        // O(n^2) runtime
//        startTime = System.currentTimeMillis();
//        SelectionSort.selectionSort(theInts);
//        System.out.println((System.currentTimeMillis() - startTime) + "ms selection sort");
//        System.out.println(theInts);


        Collections.shuffle(theInts);


        // O(nlog(n)) runtime
        startTime = System.currentTimeMillis();
        List<Integer> sortedList = MergeSort.mergeSort(theInts);
        System.out.println((System.currentTimeMillis() - startTime) + "ms merge sort");
//        System.out.println(sortedList);


        Collections.shuffle(theInts);

        // Try this for comparison to an efficient implementation
        startTime = System.currentTimeMillis();
        Collections.sort(theInts);
        System.out.println((System.currentTimeMillis() - startTime) + "ms Collections.sort");
//        System.out.println(theInts);

    }

}
