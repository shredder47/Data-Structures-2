package datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RBTTest {

    private RBT rbt;

    @Before
    public void SetUp() {
        rbt = new RBT();
    }

    @Test
    public void logicCheckDemo() {
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(50);
        rbt.insert(40);
        rbt.insert(60);
        rbt.insert(70);
        rbt.insert(80);



        System.out.println(rbt);

    }



}

