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
        rbt.insert(4);
        rbt.insert(8);

        Assert.assertEquals("(40 , B) (20 , R) (8 , B) (4 , R) (10 , R) (30 , B) (60 , R) (50 , B) (70 , B) (80 , R) ",rbt.preOrderPrint());


    }



}

