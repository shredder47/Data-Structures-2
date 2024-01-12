package algorithms;

import java.util.Arrays;

public class QuickSort {


    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }


    public void sort(int[] data, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(data, low, high);

            //Sort all the elements before pivot index
            sort(data, low, pivotIndex - 1);

            //sort all the elements after pivot index
            sort(data, pivotIndex + 1, high);

        }


    }


    public int partition(int[] data, int low, int high) {

        // getting the current pivot value
        int pivotValue = data[high];

        // this will help sending value lower than pivot to left side
        int k = low - 1;

        // scanning all elements before high

        for (int i = low; i < high; i++) {

            // Once we get the value lower than pivot, make a space and put it there and push the existing element forward
            if (data[i] < pivotValue) {
                //swap
                k++;
                int temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }
        //if all values are less than pivot, then k will be equal to high
        // for input 1 8 3 9 4 5 7,  k will reach till 3, then pivot will come at 4, making [1, 3, 4, 5, 7, 9, 8],
        k++;
        int temp = data[k];
        data[k] = pivotValue;
        data[high] = temp;

        return k;
    }

    public void printArray(int[] data) {

        for (int datum : data) System.out.print(datum + " ");
        System.out.println();
    }


}
