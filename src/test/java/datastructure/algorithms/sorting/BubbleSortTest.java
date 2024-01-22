package datastructure.algorithms.sorting;

import algorithms.sorting.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {

    @Test
    public void Sort() {

        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        BubbleSort bubbleSort = new BubbleSort(arr);
        bubbleSort.sort();
        Assert.assertArrayEquals(new int[]{1, 3, 4, 5, 7, 8, 9}, bubbleSort.arr);
    }

    @Test
    public void Sort2() {

        int[] arr = new int[20];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(20);
        }

        BubbleSort bubbleSort = new BubbleSort(arr);
        bubbleSort.sort();
        bubbleSort.printItems();
        Assert.assertArrayEquals(Arrays.stream(arr).sorted().toArray(), bubbleSort.arr);
    }

}
