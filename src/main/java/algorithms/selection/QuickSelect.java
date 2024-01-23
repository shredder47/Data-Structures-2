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

            if (kth == pivotIndex) return data[pivotIndex];

            if (pivotIndex > kth) {
                return quickSelect(data, low, pivotIndex - 1, kth);
            } else
                return quickSelect(data, pivotIndex + 1, high, kth);
        }


        return -1;

    }

    private int partition(int[] data, int low, int high) {

        int k = low - 1;
        int pivotValue = data[high];


        for (int i = low; i < high; i++) {

            if (data[i] < pivotValue) {
                k++;

                int temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }

        }
        k++;
        int temp = data[k];
        data[k] = data[high];
        data[high] = temp;

        return k;

    }


}
