package datastructure;

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

        /*


         */
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

}

