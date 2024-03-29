package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    /*
            In case of selection sort we repeatedly find the minimum element and move it to the sorted part of array
            to make unsorted part sorted
     */

    public void sort() {
//           k                              k                           k
//           ||                           |     |                    |      |
//           {1, 8, 3, 9, 4, 5, 7} ->     {1, 8, 3, 9, 4, 5, 7}  -> {1, 3, 8, 9, 4, 5, 7}

        int sortRange = 0;

        while (sortRange < arr.length) {

            int minVal = arr[sortRange];
            int minIndex = sortRange;

            for (int i = sortRange; i < arr.length; i++) {

                if (arr[i] < minVal) {
                    minVal = arr[i];
                    minIndex = i;
                }
            }
            swap(sortRange, minIndex);
            sortRange++;
        }
    }


    private void swap(int position1, int position2) {

        int temp = arr[position2];

        arr[position2] = arr[position1];
        arr[position1] = temp;

    }

    public void printItems() {
        System.out.println(Arrays.toString(arr));
    }

}
