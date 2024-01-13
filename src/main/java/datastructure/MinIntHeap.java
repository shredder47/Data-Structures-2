package datastructure;

public class MinIntHeap {

    int size;
    int INIT_CAP = 8;
    int[] data;

    public MinIntHeap() {
        data = new int[INIT_CAP];
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    public boolean hasParent(int childIndex) {
        return (getParentIndex(childIndex) >= 0);
    }

    public boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    public boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }


    public void insert(int val) {

        //Check arr capacity
        if (size == INIT_CAP) resize();

        // add item to the last block
        data[size] = val;
        size++;

        heapifyUP();

    }

    public int extractMin() {
        if(size == 0) return 0;

        int min = data[0];
        data[0] = data[size - 1];
        size--;

        heapifyDOWN();
        return min;
    }

    private void heapifyDOWN() {

        int currentIndex = 0;
        int currentValue = data[currentIndex];


        //keep traversing till it reaches the end/size
        while (currentIndex < size) {

            // as its ACBT, it should have a left, then only right can exist
            if (hasLeftChild(currentIndex)) {

                int lowestChildIndex;

                if (hasRightChild(currentIndex) && data[getRightChildIndex(currentIndex)] < data[getLeftChildIndex(currentIndex)]) {
                    lowestChildIndex = getRightChildIndex(currentIndex);
                } else
                    lowestChildIndex = getLeftChildIndex(currentIndex);

                if (currentValue > data[lowestChildIndex])
                    swap(currentIndex, lowestChildIndex);
                else
                    break;

                currentIndex = lowestChildIndex;
            } else {
                return;
            }
        }

    }

    private void heapifyUP() {

        int currentIndex = size - 1;
        int insertValue = data[currentIndex];

        // Keep traversing Up till it reaches root
        while (currentIndex > 0) {

            //If the current Index has parent, do the swapping logic else keep it as it is
            if (hasParent(currentIndex)) {
                int parentIndex = getParentIndex(currentIndex);
                int parentValue = data[parentIndex];

                // if parent is greater than inserted value then swap else nothing to do, break
                if (parentValue > insertValue)
                    swap(parentIndex, currentIndex);
                else
                    break;
                // go to the parent and recheck same logic
                currentIndex = parentIndex;
            } else {
                // No parent hence nothing to do, must be root :)
                return;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void resize() {
        int newSize = INIT_CAP * 2;
        int[] newData = new int[newSize];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        INIT_CAP = newSize;
        data = newData;


    }

}
