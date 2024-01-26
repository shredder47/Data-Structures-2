package datastructure.algorithms.search;

import algorithms.search.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {


    @Test
    public void search1() {

        int[] arr = new int[]{1, 2, 3,4, 5, 6, 7, 8, 9};

        BinarySearch binarySearch = new BinarySearch();
        Assert.assertEquals(2, binarySearch.performBinarySearch(3, arr));

    }

    @Test
    public void search2() {

        int[] arr = new int[]{1, 2, 3,4, 5, 6, 7, 8, 9};

        BinarySearch binarySearch = new BinarySearch();
        Assert.assertEquals(8, binarySearch.performBinarySearch(9, arr));

    }

    @Test
    public void search3() {

        int[] arr = new int[]{1, 2, 3,4, 5, 6, 7, 8, 9};

        BinarySearch binarySearch = new BinarySearch();
        Assert.assertEquals(3, binarySearch.performBinarySearch(4, arr));

    }

    @Test
    public void search4() {

        int[] arr = new int[]{1, 2, 3,4, 5, 6, 7, 8, 9};

        BinarySearch binarySearch = new BinarySearch();
        Assert.assertEquals(-1, binarySearch.performBinarySearch(100, arr));

    }

    @Test
    public void search5() {

        int[] arr = new int[]{10,11,16,20};

        BinarySearch binarySearch = new BinarySearch();
        Assert.assertEquals(-1, binarySearch.performBinarySearch(13, arr));

    }

}
