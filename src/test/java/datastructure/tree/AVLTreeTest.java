package datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {

    private AVL avl;

    @Before
    public void SetUp() {
        avl = new AVL();
    }

    @Test
    public void logicCheckDemo() {
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);

        avl.prettyPrint();
    }

    @Test
    public void LeftLeft() {
        avl.insert(7);
        avl.insert(6);
        avl.insert(5);
        avl.insert(4);
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);


        avl.prettyPrint();

        /*

             4
            /  \
           2    6
          / \  / \
         1  3 5   7

         */
    }

    @Test
    public void RightRight() {
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);

        avl.prettyPrint();

        /*
        30
          \             40
          40      >    /  \
            \        30    50
             50
         */
    }

    @Test
    public void LeftRight() {
        avl.insert(30);
        avl.insert(20);
        avl.insert(25);

        avl.prettyPrint();

        /*
           30           30
          /            /          25
        20      >    25     >    /  \
          \         /          20    30
          25      20
         */
    }

    @Test
    public void RightLeft() {
        avl.insert(30);
        avl.insert(40);
        avl.insert(35);

        avl.prettyPrint();

        /*
        30          30
          \           \             35
           40   >      35   >      /  \
          /              \       30    40
        35                40
         */
    }

    @Test
    public void delete1() {
        // Insertion Order
        // 9,5,10,0,6,11,-1,1,2,44,23,52,12,45,65,66,67,68,69,1212


        avl.insert(9);
        avl.insert(5);
        avl.insert(10);
        avl.insert(0);
        avl.insert(6);
        avl.insert(11);
        avl.insert(-1);
        avl.insert(1);
        avl.insert(2);
        avl.insert(44);
        avl.insert(23);
        avl.insert(52);
        avl.insert(45);
        avl.insert(65);
        avl.insert(66);
        avl.insert(67);
        avl.insert(68);
        avl.insert(69);
        avl.insert(1212);


        Assert.assertEquals("9 1 0 -1 5 2 6 66 44 11 10 23 52 45 65 68 67 69 1212 ",avl.getPreOrderString());

        avl.deleteNode(69);
        Assert.assertEquals("9 1 0 -1 5 2 6 66 44 11 10 23 52 45 65 68 67 1212 ",avl.getPreOrderString());

    }

    @Test
    public void delete2() {
        // Insertion Order
        // 9,5,10,0,6,11,-1,1,2,44,23,52,12,45,65


        avl.insert(30);
        avl.insert(35);
        avl.insert(40);
        avl.insert(50);
        avl.insert(20);

        avl.prettyPrint();
        System.out.println("After deleting 50");
        avl.deleteNode(50);
        avl.prettyPrint();
        Assert.assertEquals("35 30 20 40 ", avl.getPreOrderString());
        System.out.println("\n\nAfter deleting 40");
        avl.deleteNode(40);
        avl.prettyPrint();
        Assert.assertEquals("30 20 35 ", avl.getPreOrderString());


    }

}

