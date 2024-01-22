package datastructure.algorithms.sorting;

import algorithms.sorting.BubbleSort;
import algorithms.sorting.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortTest {

    @Test
    public void Sort() {

        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.sort();
        insertionSort.printItems();
        Assert.assertArrayEquals(new int[]{1, 3, 4, 5, 7, 8, 9}, insertionSort.arr);
    }

    @Test
    public void Sort2() {

        int[] arr = new int[20];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(20);
        }

        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.sort();
        insertionSort.printItems();
        Assert.assertArrayEquals(Arrays.stream(arr).sorted().toArray(), insertionSort.arr);
    }

}
