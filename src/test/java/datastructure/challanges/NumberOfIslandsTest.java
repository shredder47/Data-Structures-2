package datastructure.challanges;

import challanges.NumberOfIslands;
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

        int i = number.numberOfIslands('L');
        System.out.println(i);


    }

}
