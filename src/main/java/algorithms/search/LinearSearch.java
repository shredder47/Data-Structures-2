package algorithms.search;

public class LinearSearch {

    public int performLinearSearch(int num,int[] arr){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) return i;
        }
        return -1;
    }

}
