package datastructure;

import static java.lang.Math.max;

public class RBT {

    Node root;

    public RBT() {
    }

    private Node insert(Node node, int key,Node parent) {

        // Base Case when node is null add a new Node
        if (node == null) {

            Node newNode = new Node();
            newNode.key = key;
            newNode.red = true;
            newNode.parent = parent;
            if (parent == null) {
                newNode.red = false; // cos root
            }
            return newNode;
        }

        if (key < node.key) {
            node.left = insert(node.left, key, node); // add the mutated node to the left of current Node
        } else if (key > node.key) {
            node.right = insert(node.right, key, node); // add the mutated node to the right of current Node
        } else
            return node;// As duplicate not possible

        // Case1:

        if(isBlackNode(node) & hasRedRightChild(node) && hasRedRightGrandChild(node) & hasLeftRedUncle(node)) {
            //Swap Colors
            node.red = true;
            node.right.red=false;
            node.right.right.red = true;
            node.left.red = false;

        }

        if(isBlackNode(node)  && hasRedRightChild(node) && hasRedRightGrandChild(node) && hasLeftBlackUncle(node)){
           node =  rotateLeft(node);
        }

        if(isBlackNode(node)  && hasRedRightChildAndRedLeftGrandChild(node) && hasLeftBlackUncle(node)){
            node.right =  rotateRight(node.right);
            node =  rotateLeft(node);
        }


        if(isBlackNode(node) & hasRedLeftChild(node) && hasRedLeftGrandChild(node) & hasRightRedUncle(node)) {
            //Swap Colors
            node.red = true;
            node.right.red=false;
            node.left.left.red = true;
            node.left.red = false;

        }

        if(isBlackNode(node) & hasRedLeftChild(node) && hasRedLeftGrandChild(node) & hasRightBlackUncle(node)) {
            node = rotateRight(node);
        }

        if(isBlackNode(node) & hasRedLeftChildAndRedRightGrandChild(node) & hasRightBlackUncle(node)) {
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }


        if (node.parent == null)
            node.red = false;


        return node;
    }

    public boolean isBlackNode(Node node){
        return  !node.red;
    }

    // Right CHECK Routines

    public boolean hasRightBlackUncle(Node node){
        return node.right == null ||( node.right != null && !node.right.red);
    }

    public boolean hasRedRightChildAndRedLeftGrandChild(Node node){
        return (hasRedRightChild(node) && (node.right.left != null && node.right.left.red));
    }
    public boolean hasRightRedUncle(Node node){
        if(node.right == null)
            return false; // Black Node
        return node.right.red;
    }

    public boolean hasRedRightChild(Node node) {
        return node.right != null && node.right.red;
    }
    public boolean hasRedRightGrandChild(Node node) {
        return node.right.right != null && node.right.right.red;
    }

    //Left Check Routines
    public boolean hasLeftBlackUncle(Node node){
        return node.left == null ||( node.left != null && !node.left.red);
    }

    public boolean hasRedLeftChild(Node node) {
        return node.left != null && node.left.red;
    }
    public boolean hasRedLeftGrandChild(Node node) {
        return node.left.left != null && node.left.left.red;
    }

    public boolean hasLeftRedUncle(Node node) {
        if(node.left == null ) return false; //Black Uncle
        return (node.left.red);

    }

    public boolean hasRedLeftChildAndRedRightGrandChild(Node node){
        return hasRedLeftChild(node) && node.left.right != null && node.left.right.red;
    }





    public void insert(int key) {

        root = insert(root, key,root);

    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;

        //
        return height(node.left) - height(node.right);
    }


    public int h(Node n) {
        if (n == null)
            return -1;
        return Math.max(1 + h(n.left), 1 + h(n.right));

    }

    public int treeHeight() {
        return h(root);
    }


    // Standard Routine Functions
    public int height(Node node) {
        if (node == null)
            return 0;
        else
            return node.nodeHeight;
    }



    /*


            X
           / \
          T1  Y                                         Y
             / \          Left Rotate                  / \
            T2  T3    --------------------->          X   T3
                                                     / \
                                                    T1  T2

     */

    private Node rotateLeft(Node x) {

        Node y = x.right;
        y.parent = x.parent;

        Node T2 = y.left;
        Node T3 = y.left;

        y.left = x;

        x.right = T2;
        x.parent = y;
        if(T2 != null) T2.parent = x;
        if(T3 != null) T3.parent = y;
        y.red = false;
        x.red = true;
        if(T3 != null ) T3.red = true;

        return y; //Important to send y
    }


    /*


              Y
            /  \         Right Rotation
           X   T3     --------------------->            X
          / \                                          / \
        T1  T2                                        T1  Y
                                                         / \
                                                        T2  T3

     */
    private Node rotateRight(Node y) {

        Node x = y.left;
        x.parent = y.parent;
        Node T1 = x.left;
        Node T2 = x.right;

        x.right = y;
        y.parent = x;
        y.left = T2;
        if(T2 != null) T2.parent = y;
        if(T1 != null) T1.parent = x;

        x.red = false;
        y.red = true;
        if(T1 != null) T1.red = true;




        return x;
    }

    public static class Node {

        int key;
        boolean red;
        Node left;
        Node right;

        int nodeHeight;

        Node parent;


        public Node() {
        }

        public Node(int key, Node parent) {
            this.key = key;
            this.red = true; // Initially all new nodes are RED in color
            this.parent = parent;
            this.nodeHeight = 1;
        }

        public Node(int key,boolean isRed,Node parent) {
            this.key = key;
            this.red = isRed;
            this.parent = parent;
            this.nodeHeight = 1;
        }

        public Node getMin() {
            //IF current node has missing left, that means this is the last item at left
            if (left == null)
                return this;
            else
                return left.getMin();// Rerun the same function on current node's left
        }
    }

}



