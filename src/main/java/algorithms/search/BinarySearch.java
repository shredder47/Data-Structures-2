package algorithms.search;

public class BinarySearch {


    //1,2,3,4,5,6,7,8
    public int performBinarySearch(int num, int[] arr) {

        return binarySearch(num, arr, 0, arr.length - 1);
    }

    private int binarySearch(int num, int[] arr, int startIndex, int endIndex) {

        //Base case when comparison gets invalid index, start index much be lower than end index
        if (startIndex > endIndex)
            return -1;

        //For searching divide the arr into two parts and do independent search
        int midIndex = (startIndex + endIndex) / 2;

        //if number is found, return that index, which will happen to be the mid-index
        if (arr[midIndex] == num)
            return midIndex;

        //if the number is less than mid-value, then the number must be on the right side of the mid as its sorted array
        if (num < arr[midIndex]) {
            return binarySearch(num, arr, startIndex, midIndex);
        } else {
            return binarySearch(num, arr, midIndex + 1, endIndex);
        }


    }

}

