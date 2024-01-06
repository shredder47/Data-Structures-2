package datastructure;

public class AVL {

    Node root;

    public AVL() {
    }

    public int height(Node node){
        if (node == null)
            return 0;
        else
            return node.nodeHeight;
    }

    public void insert(int key) {

        root = insert(root, key);

    }

    /*
              Y
            /  \         Right Rotation
           X   T3     --------------------->            X
          / \         <--------------------            / \
        T1  T2           Left Rotation                T1  Y
                                                         / \
                                                        T2  T3
     */

           /*
              30                          30                                              30                                    20
             /         20                /                                               /                                     /  \
           20    >    /  \              20        --> RotateLeft(30.left)              20       -->  RotateRight(30)  ->>    25    30
          /         10    30              \                                           /
        10                                25                                         25
         */

    /*/**********************************************************************************************************
     *  Situation when inserting 10, after successfully insertion of 10, all the node balances went well butt when recursing back to node 30, RR situation arises
     *
     *       30   h = 3,  nB = 2     -->  h(30.left) - h(null.right) -> (2-0) = 2 which is greater than 1, Triggering LL
     *       /
     *     20     h = 2,  nB = 1    ^
     *    /                         |
     *  10        h = 1,  nB = 0;   |
     *                              |
     ******************/


    public Node insert(Node node, int key) {

        // Base Case when node is null add a new Node
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key); // add the mutated node to the left of current Node
        } else if (key > node.key) {
            node.right = insert(node.right, key); // add the mutated node to the right of current Node
        } else
            return node;// As duplicate not possible

        // After successful node assignment , increase the height of the current node
        // height of current node = max height of any child + 1 (counting himself)
        node.nodeHeight = 1 + Math.max(height(node.left),height(node.right));

        int nodeBalance = getBalance(node);

        //Case LL
        if(nodeBalance > 1 && key < node.left.key ){
            return rotateRight(node) ; // perform LL rotation

        }
        //Case LR
        if(nodeBalance > 1 && key > node.left.key){
            node.left = rotateLeft(node.left);// Make it LL
            return rotateRight(node); //  perform LL rotation

        }
        //CASE RR
        if(nodeBalance < -1 && key > node.right.key  ){
            return rotateLeft(node) ; // perform left rotation

        }
        //Case RL
        if(nodeBalance < -1 && key < node.right.key){
            node.right = rotateRight(node.right);// Make it RR
            return rotateLeft(node); //  perform left rotation

        }

        return node;
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

    private Node rotateRight(Node Y) {

        Node X = Y.left;
        Node T2 = X.right; // coz Y will be inserted here, else this pointer will be lost

        //SWAP
        X.right = Y;
        Y.left = T2;

        // Update the heights after the rearrangement
        Y.nodeHeight = 1 + Math.max(height(Y.left),height(Y.right)); // Imp to update Y first
        X.nodeHeight = 1 + Math.max(height(X.left),height(Y.right));

        return X; //Important to send X
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

    private Node rotateLeft(Node X) {

        Node Y = X.right;
        Node T2 = Y.left; // coz X will be inserted here, else this pointer will be lost

        //SWAP
        Y.left = X;
        X.right = T2;

        // Update the heights after the rearrangement
        X.nodeHeight = 1 + Math.max(height(X.left),height(X.right)); // Imp to update X first
        Y.nodeHeight = 1 + Math.max(height(Y.left),height(Y.right));

        return Y; //Important to send Y
    }

    // if balance less than -1 or more, then 1 then needs balancing
    private int getBalance(Node node) {
        if(node == null)
            return 0;

        //
        return height(node.left) - height(node.right);
    }

    public void printInOrderTraversal() {
        printInOrderTraversal(root);
    }

    public void printInOrderTraversal(Node node){
        if (node == null)
            return;

        printInOrderTraversal(node.left);
        System.out.println(node.key);
        printInOrderTraversal(node.right);
    }


    public static class Node {

        int key;
        int nodeHeight;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.nodeHeight = 1; // Initial Height will always be one
        }
    }

    public void prettyPrint() {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }

}



