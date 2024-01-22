package datastructure.algorithms.sorting;

import algorithms.sorting.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {

    @Test
    public void Sort() {

        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        SelectionSort selectionSort = new SelectionSort(arr);
        selectionSort.sort();
        selectionSort.printItems();
        Assert.assertArrayEquals(new int[]{1, 3, 4, 5, 7, 8, 9}, selectionSort.arr);
    }

    @Test
    public void Sort2() {

        int[] arr = new int[20];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(20);
        }

        SelectionSort selectionSort = new SelectionSort(arr);
        selectionSort.sort();
        selectionSort.printItems();
        Assert.assertArrayEquals(Arrays.stream(arr).sorted().toArray(), selectionSort.arr);

    }

}
