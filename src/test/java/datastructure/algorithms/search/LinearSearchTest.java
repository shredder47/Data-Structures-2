package datastructure.algorithms.search;

import algorithms.search.LinearSearch;
import org.junit.Assert;
import org.junit.Test;

public class LinearSearchTest {

    @Test
    public void search1() {

        int[] arr = {1,8,3,9,4,5,7};
        LinearSearch linearSearch = new LinearSearch();
        Assert.assertEquals(2, linearSearch.performLinearSearch(3, arr));

    }
    @Test
    public void search2() {

        int[] arr = {1,8,3,9,4,5,7};
        LinearSearch linearSearch = new LinearSearch();
        Assert.assertEquals(-1, linearSearch.performLinearSearch(11, arr));

    }

}
