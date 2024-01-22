package datastructure.algorithms.sorting;

import algorithms.sorting.MergeShort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

    private MergeShort mergeSort;

    @Before
    public void SetUp() {
        mergeSort = new MergeShort();

    }

    @Test
    public void Sort() {

        int[] arr = {4, 7, 14, 1, 3, 9, 17};


        mergeSort.sort(arr);

        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(3, arr[1]);
        Assert.assertEquals(4, arr[2]);
        Assert.assertEquals(7, arr[3]);
        Assert.assertEquals(9, arr[4]);
        Assert.assertEquals(14, arr[5]);
        Assert.assertEquals(17, arr[6]);

        System.out.println("\nSorted array");
        mergeSort.printArray(arr);
    }

    @Test
    public void randomNumberSort10() {

        int[] arr = new int[10];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(10);
        }


        System.out.println("Before");
        System.out.println(Arrays.toString(arr));
        mergeSort.sort(arr);
        System.out.println("\nSorted array");
        mergeSort.printArray(arr);
    }

    @Test
    public void randomNumberSort100000() {

        int[] arr = new int[100000];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(100000);
        }

        System.out.println("Before");
        System.out.println(Arrays.toString(arr));
        mergeSort.sort(arr);
        System.out.println("\nSorted array");
        mergeSort.printArray(arr);
    }

}
