package datastructure.dynamicprogamming;

import dynamicprogamming.StandaloneFunctions;
import org.junit.Test;

public class StandaloneFunctionsTest {


    @Test
    public void canSum() {

        StandaloneFunctions s = new StandaloneFunctions();
        System.out.println(s.canSum(7, new long[]{2, 3})); // [3,2,2]
        System.out.println(s.canSum(7, new long[]{5,3,4,7})); // [4,3]
        System.out.println(s.canSum(7, new long[]{2, 4})); // null
        System.out.println(s.canSum(8, new long[]{2, 3,5})); // [2,2,2,2]
        System.out.println(s.canSum(300, new long[]{7, 14})); // null

    }


}