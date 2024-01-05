package datastructure;

public class MaxIntHeap {

    int INIT_CAP = 8;
    int size = 0;

    int[] data;

    public MaxIntHeap() {
        data = new int[INIT_CAP];
    }

    // Helper Routines

    public int getParentIndex(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        return parentIndex;
    }

    public int getRightChildIndex(int parentIndex) {
        int rightChildIndex = (2 * parentIndex + 2);
        return rightChildIndex;
    }

    public int getLeftChildIndex(int parentIndex) {
        int leftChildIndex = (2 * parentIndex + 1);
        return leftChildIndex;
    }

    public boolean hasParent(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        if (parentIndex < 0)
            return false; // if index is 0 or less than it, that means its root or invalid index
        else
            return true;
    }

    public boolean hasLeftChild(int parentIndex) {

        int leftChildIndex = getLeftChildIndex(parentIndex);
        return leftChildIndex < size; // if index is exceeding the current size, we can say no child
    }

    public boolean hasRightChild(int parentIndex) {
        int rightChildIndex = getRightChildIndex(parentIndex);
        return rightChildIndex < size; // if index is exceeding the current size, we can say no child
    }

  /*

           42
          /  \
         29   18

         insert(35)

           42
          /  \
         29   18
        /
       35
          | |

           42
          /  \
         35   18
        /
       29

   */

    public void insert(int value) {
        // Check Capacity
        if (size == INIT_CAP) expand();

        //insert the item to the last index of array
        data[size] = value;
        size++;

        heapUp();

    }

    private void heapUp() {

        //Get the last entry
        int currentIndex = size - 1;

        int value = data[currentIndex];

        // compare with his parent till it reaches to the root
        while (currentIndex > 0) {

            if (hasParent(currentIndex)) {

                int parentIndex = getParentIndex(currentIndex);
                int parentValue = data[parentIndex];

                if (value > parentValue) {
                    //SWAP
                    swap(currentIndex, parentIndex);
                } else {
                    break;
                }
                currentIndex = parentIndex;

            } else {
                return;
            }


        }
    }

    public int extractMax() {

        if (size == 0) return 0;

        //getting the data to be extracted, which is at front
        int maxItem = data[0];

        // assigning the last element of the tree to the top
        data[0] = data[size - 1];

        // reducing the size of the data by 1
        size--;

        heapDown();

        return maxItem;
    }

    private void heapDown() {

        int currentIndex = 0;

        //Going down from top till it reaches end of size

        while (currentIndex < size) {

            //Checking if the current index has left child
            //without having left, it cannot have right,else not complete binary tree
            if (hasLeftChild(currentIndex)) {

                int currentNodeValue = data[currentIndex];
                int highestChildIndex;

                if (hasRightChild(currentIndex) && data[getRightChildIndex(currentIndex)] > data[getLeftChildIndex(currentIndex)]) {
                    highestChildIndex = getRightChildIndex(currentIndex);
                } else
                    highestChildIndex = getLeftChildIndex(currentIndex);

                if (currentNodeValue < data[highestChildIndex]) {
                    swap(currentIndex, highestChildIndex);
                }
                currentIndex = highestChildIndex;
            } else {
                return;
            }
        }


    }


    public void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public void expand() {

        int[] newData = new int[INIT_CAP * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        INIT_CAP = INIT_CAP * 2;

    }

}
