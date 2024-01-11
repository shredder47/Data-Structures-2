package algorithms;

public class MergeShort {

    int[] data;

    public MergeShort(int[] data) {
        this.data = data;
    }


    public void sort() {
        // Important to send end as data.length - 1
        sort(data, 0, data.length - 1);
    }

//                     s                        m                    e
//                   [ 7    ,   6   ,   5   ,   4   ,   3   ,   2   ,1 ]
//                     0        1       2       3       4       5    6

    private void sort(int[] data, int startIndex, int endIndex) {

        if (startIndex >= endIndex)
            return;

        int midIndex =  (endIndex + startIndex) / 2;

        sort(data, startIndex, midIndex);
        sort(data, midIndex + 1, endIndex);

        mergeArr(data,startIndex,midIndex,endIndex);

    }

    private void mergeArr(int[] data, int startIndex, int midIndex, int endIndex) {

        int[] mergeArr = new int[endIndex - startIndex + 1];

        int leftPointer = startIndex;
        int rightPointer = midIndex + 1;
        int mergeArrPointer = 0;

        //do the comparison and populate the mergeArr
        while (leftPointer <= midIndex && rightPointer <= endIndex){

            if(data[leftPointer] <= data[rightPointer])
                mergeArr[mergeArrPointer++] = data[leftPointer++];
            else
                mergeArr[mergeArrPointer++] =  data[rightPointer++];
        }

        while (leftPointer <=midIndex){
            mergeArr[mergeArrPointer++] = data[leftPointer++];
        }
        while ((rightPointer <= endIndex)){
            mergeArr[mergeArrPointer++] = data[rightPointer++];
        }

        for (int i = 0, j=startIndex; i < mergeArr.length; i++,j++) {
            data[j] = mergeArr[i];

        }

    }
    public void printArray()
    {

        for (int datum : data) System.out.print(datum + " ");
        System.out.println();
    }

}

