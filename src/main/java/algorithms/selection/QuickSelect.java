package algorithms.selection;

public class QuickSelect {

    int[] data;

    public QuickSelect(int[] data) {
        this.data = data;
    }

    public int quickSelect(int kth) {
        return quickSelect(data, 0, data.length - 1, kth - 1);
    }

    private int quickSelect(int[] data, int low, int high, int kth) {

        if (low <= high) {
            int pivotIndex = partition(data, low, high);

            if (kth < pivotIndex) return quickSelect(data, low, pivotIndex - 1, kth); //if the index to find is less than pivot,check the left,coz all smaller items are on the left of pivot
            else if ((kth > pivotIndex)) return quickSelect(data, pivotIndex + 1, high, kth);
            else return data[kth];
        }
        return -1;
    }

    private int partition(int[] data, int low, int high) {

        int k = low - 1;
        int pivotValue = data[high];


        for (int i = low; i < high; i++) {
            if (data[i] < pivotValue) {
                k++;
                swap(data, k, i);
            }
        }
        k++;
        swap(data, k, high);

        return k;

    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


}
