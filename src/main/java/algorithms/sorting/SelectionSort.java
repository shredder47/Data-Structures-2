package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
//          k                             k                         k
//          ||                            |  |                      |    |
//           {1, 8, 3, 9, 4, 5, 7} ->     {1, 8, 3, 9, 4, 5, 7}  -> {1, 3, 8, 9, 4, 5, 7}

        int k = 0;

        while (k < arr.length) {

            int minVal = arr[k];
            int minIndex = k;

            for (int i = k; i < arr.length; i++) {

                if (arr[i] < minVal) {
                    minVal = arr[i];
                    minIndex = i;
                }
            }
            swap(k, minIndex);
            k++;
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
