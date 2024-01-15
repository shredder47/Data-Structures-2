package datastructure.dynamicprogamming;

import dynamicprogamming.GridTraveller;
import org.junit.Assert;
import org.junit.Test;

public class GridTravellerTest {


    @Test
    public void traveller1()  {

        GridTraveller gridTraveller  = new GridTraveller();
        Assert.assertEquals(3,gridTraveller.numWays(2, 3));
        Assert.assertEquals(2333606220L,gridTraveller.numWaysMemo(18,18));


    }

}