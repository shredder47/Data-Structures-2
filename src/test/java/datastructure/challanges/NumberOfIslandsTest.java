package datastructure.challanges;

import challanges.NumberOfIslands;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsTest {


    @Test
    public void getIsland1() {
        Character[][] arr = {
                {'W','L','W','W','W'},
                {'W','L','W','W','W'},
                {'W','W','W','L','W'},
                {'W','W','L','L','W'},
                {'W','W','W','L','L'},
                {'L','L','W','W','W'},
        };


        NumberOfIslands<Character> number = new NumberOfIslands<>(arr);

        Assert.assertEquals(2,number.getMinIsland('L'));
        Assert.assertEquals(3,number.getNumberOfIsland('L'));

    }

    @Test
    public void getIsland2() {
        Integer[][] arr = {
                {1,0,0,0,1},
                {1,0,1,1,1},
                {1,0,1,1,1},
                {1,0,0,0,1},

        };


        NumberOfIslands<Integer> number = new NumberOfIslands<>(arr);

        Assert.assertEquals(4,number.getMinIsland(1));
        Assert.assertEquals(2,number.getNumberOfIsland(1));

    }

}
