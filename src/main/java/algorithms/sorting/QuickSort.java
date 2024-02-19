package algorithms.sorting;

public class QuickSort {

    /*
        - Quick sort is a divide and conquer algorithm
        - Find pivot number and make sure smaller numbers located at the left of pivot, and bigger numbers
          are located at the right of the pivot.
        - Unlike merge sort, extra space is not required
     */

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }


    public void sort(int[] data, int low, int high) {

        if (low >= high)
            return;

        int pivotIndex = partition(data, low, high);

        //Sort all the elements before pivot index
        sort(data, low, pivotIndex - 1);

        //sort all the elements after pivot index
        sort(data, pivotIndex + 1, high);

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
                swap(data, k, i);
            }
        }
        //if all values are less than pivot, then k will be equal to high
        // for input 1 8 3 9 4 5 7,  k will reach till 3, then pivot will come at 4, making [1, 3, 4, 5, 7, 9, 8],
        k++;
        swap(data, k, high);

        return k;
    }

    public void printArray(int[] data) {

        for (int datum : data) System.out.print(datum + " ");
        System.out.println();
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

}

//day1- 13
