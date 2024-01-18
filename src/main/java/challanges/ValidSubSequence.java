package challanges;

public class ValidSubSequence {

    int arr[];
    int seq[];

    public ValidSubSequence(int[] arr, int[] seq) {
        this.arr = arr;
        this.seq = seq;
    }

    //5,1,22,25,6,-1,8,10
    //1,6,-1,10

    public boolean isValid(){

        int arrPtr = 0;

        for (int i = 0; i < seq.length; i++) {

            while (arrPtr < arr.length){

                if(seq[i] == arr[arrPtr]){
                    break;
                }

                arrPtr++;
            }
            if(arrPtr == arr.length ) return false;
        }

        return true;
    }

}
