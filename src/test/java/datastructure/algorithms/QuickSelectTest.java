package datastructure.algorithms;

import algorithms.QuickSelect;
import org.junit.Assert;
import org.junit.Test;

public class QuickSelectTest {

    private QuickSelect quickSelect;


    @Test
    public void Sort() {

        int[] arr = {1,8,3,9,4,5,7};
        quickSelect = new QuickSelect(arr);
        Assert.assertEquals(3,quickSelect.quickSelect(2));

    }

}
