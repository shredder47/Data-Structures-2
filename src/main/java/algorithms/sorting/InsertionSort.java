package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {


    public int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    /*
        - Divide the given array into two parts
        - Take a first element from an unsorted array and find its correct position in sorted array
        - Repeat until an unsorted array is empty
     */

    //    sr=1                  sr=2               sr=3                  sr=4
    //     |                    |                    |                     |
    //  8,[4],5,2,1,7,9 -> 4,8,[5],2,1,7,9 -> 4,5,8,[2],1,7,9  -> 2,4,5,8,[1],7,9 and so on...
    //                                     -> 4,5,[2],8,1,7,9
    //                                     -> 4,[2],5,8,1,7,9
    //                                     -> [2],4,5,8,1,7,9
    // [ ] represent the current value's updated index,initially starts with sr,then gets updated every swap
    public void sort() {

        int sortRange = 1; //sr

        while (sortRange < arr.length) {

            int currentValue = arr[sortRange];
            int currentIndex = sortRange; // initial Index is for comparing is the last item of sortRange

            // start checking from last item of the sorted section
            for (int i = sortRange - 1; i >= 0; i--) { // sr -1 to avoid double-checking with itself
                if (currentValue < arr[i]) {
                    swap(currentIndex, i);
                    currentIndex = i; // updating the new index of the current value [] after the swap
                }
            }
            sortRange++;
        }


    }


    public void swap(int position1, int position2) {

        int temp = arr[position2];
        arr[position2] = arr[position1];
        arr[position1] = temp;
    }

    public void printItems() {
        System.out.println(Arrays.toString(arr));
    }

}
