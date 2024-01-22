package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public int[] arr;


    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void sort(){

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length -1 - i; j++) {
                //  |--|
                //  4  3 2 1
                if(arr[j] > arr[j+1]){
                    //SWAP
                    swap(j,j+1);
                }
            }
        }
    }


    private void swap(int position1,int position2){

        int temp = arr[position2];

        arr[position2] = arr[position1];
        arr[position1] = temp;

    }

    public void printItems(){
        System.out.println(Arrays.toString(arr));
    }

}
