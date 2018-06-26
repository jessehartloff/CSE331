package lecture9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessehartloff on 5/11/15.
 */
public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> objectsToSort){

        if(objectsToSort.size() <= 1){
            return objectsToSort;
        }
//        else if(objectsToSort.size() < 8){
//            return SelectionSort.selectionSort(objectsToSort);
//        }

        List<Integer> firstHalf = objectsToSort.subList(0,objectsToSort.size()/2);
        List<Integer> secondHalf = objectsToSort.subList(objectsToSort.size()/2, objectsToSort.size());

//        System.out.print(firstHalf);
//        System.out.println(secondHalf);


        return merge(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    private static List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf){

        int totalSize = firstHalf.size() + secondHalf.size();

        List<Integer> mergedList = new ArrayList<>(totalSize);
        // This is not memory efficient. For optimal efficiency, the algorithm should be performed in place

        int firstHalfPointer = 0;
        int secondHalfPointer = 0;

        for (int i = 0; i < totalSize; i++) {
            if(firstHalfPointer == (firstHalf.size())){
                //copy the rest of secondHalf
                mergedList.addAll(secondHalf.subList(secondHalfPointer, secondHalf.size()));
                break;
            }else if(secondHalfPointer == (secondHalf.size())){
                //copy the rest of firstHalf
                mergedList.addAll(firstHalf.subList(firstHalfPointer, firstHalf.size()));
                break;
            }else{
                int firstHalfElement = firstHalf.get(firstHalfPointer);
                int secondHalfElement = secondHalf.get(secondHalfPointer);

                if(firstHalfElement < secondHalfElement){
                    mergedList.add(firstHalfElement);
                    firstHalfPointer++;
                }else{
                    mergedList.add(secondHalfElement);
                    secondHalfPointer++;
                }

            }
        }

        return mergedList;
    }

}
