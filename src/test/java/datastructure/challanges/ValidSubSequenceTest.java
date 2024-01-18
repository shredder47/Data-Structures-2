package datastructure.challanges;

import challanges.NumberOfIslands;
import challanges.ValidSubSequence;
import org.junit.Assert;
import org.junit.Test;

public class ValidSubSequenceTest {


    @Test
    public void isNotValidTest() {

        int[] arr = {5,1,22,25,8,-1,6,10};
        int[] seq = {1,6,-1,10};

        ValidSubSequence s = new ValidSubSequence(arr,seq);
        Assert.assertFalse(s.isValid());
    }

    @Test
    public void isValidTest() {

        int[] arr = {5,1,22,25,6,-1,8,10};
        int[] seq = {1,6,-1,10};

        ValidSubSequence s = new ValidSubSequence(arr,seq);
        Assert.assertTrue(s.isValid());
    }


}
