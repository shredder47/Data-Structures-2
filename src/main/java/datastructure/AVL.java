package datastructure;

import static java.lang.Math.max;

public class AVL {

    Node root;

    public AVL() {
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        else
            return node.nodeHeight;
    }

    public void insert(int key) {

        root = insert(root, key);

    }

    /*
        T1, T2 and T3 are subtrees of the tree rooted with y (on left side)
        or x (on right side)

                        y                               x
                       / \     Right Rotation          /  \
                      x   T3   – - – - – - – >        T1   y
                     / \       < - - - - - - -            / \
                    T1  T2     Left Rotation            T2  T3

        Keys in both of the above trees follow the following order
              keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
        So BST property is not violated anywhere.
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


    private Node insert(Node node, int key) {

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
        node.nodeHeight = 1 + max(height(node.left), height(node.right));

        int nodeBalance = getBalance(node);

        //Case LL
        if (nodeBalance > 1 && key < node.left.key) {
            return rotateRight(node); // perform LL rotation

        }
        //Case LR
        if (nodeBalance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);// Make it LL
            return rotateRight(node); //  perform LL rotation

        }
        //CASE RR
        if (nodeBalance < -1 && key > node.right.key) {
            return rotateLeft(node); // perform left rotation

        }
        //Case RL
        if (nodeBalance < -1 && key < node.right.key) {
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
        Y.nodeHeight = 1 + max(height(Y.left), height(Y.right)); // Imp to update Y first
        X.nodeHeight = 1 + max(height(X.left), height(Y.right));

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
        X.nodeHeight = 1 + max(height(X.left), height(X.right)); // Imp to update X first
        Y.nodeHeight = 1 + max(height(Y.left), height(Y.right));

        return Y; //Important to send Y
    }

    // if balance less than -1 or more, then 1 then needs balancing
    private int getBalance(Node node) {
        if (node == null)
            return 0;

        //
        return height(node.left) - height(node.right);
    }

    public void printPreOrderTraversal() {
        printPreOrderTraversal(root);
    }

    public void printPreOrderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.key + " ");

        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);
    }

    public void deleteNode(int key) {
        root = deleteNode(root, key);
    }

      /*
           20
          /  \
        15    25
       /
      10
    */

    /**
     * Perform standard delete using BST Logic. Once Deletion is done, while recursing back, check the balance factor
     * of the visiting node and fix if required
     *
     * @param node - Root Node
     * @param key  - key to delete
     * @return Mutated Root Node
     */
    Node deleteNode(Node node, int key) {

        // PERFORM STANDARD BST DELETE

        if (node == null)
            return null;

        if (key < node.key)
            node.left = deleteNode(node.left, key);
        else if (key > node.key)
            node.right = deleteNode(node.right, key);
        else {

            // Found the Key
            // Case 1:
            if (node.left == null && node.right == null) {
                node = null; // Simply Null the current leaf node.
                return node;
            }
            // Case 2:
            else if (node.right == null) {
                node = node.left;
                return node;
            } else if (node.left == null) {
                node = node.right;
                return node;
            } else {

                //getting current node's right Child's MIN
                Node rightChildMin = node.right.getMin();

                // overriding current node's key with the min
                node.key = rightChildMin.key;

                //delete the that we just found a duplicated

                node.right = deleteNode(node.right, rightChildMin.key);
                return node;

            }
        }

        // UPDATE HEIGHT OF THE CURRENT NODE
        node.nodeHeight = max(height(node.left), height(node.right)) + 1;

        // { -1 , 0 , +1 }
        int balance = getBalance(node);

        //If balance Hampered, Do Rotations

        // Current Node is Left Heavy, Its Left Is also Left Heavy... Perform Right Rotation
        if (balance > 1 && getBalance(node.left) >= 0)
            return rotateRight(node);

        // Current Node Is Left Heavy, Its Left Node is Right heavy, Requires Left Rotation Then Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Current Node is Right Heavy and Its Right is also Heavy , Requires Left Rotation
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotateLeft(node);

        // Current Node is Right Heavy, but its Left Node is Left Heavy, Required Right Rotation then Rotate Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    String getPreOrderString() {
        return getPreOrderString(root);
    }

    private String getPreOrderString(Node node) {
        if (node == null) return "";
        return node.key + " " + getPreOrderString(node.left) + getPreOrderString(node.right);

    }

    String getInOrderString() {
        return getInOrderString(root);
    }

    private String getInOrderString(Node node) {
        if (node == null) return "";
        return getPreOrderString(node.left) + node.key + " " + getPreOrderString(node.right);
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

        public Node getMin() {
            //IF current node has missing left, that means this is the last item at left
            if (left == null)
                return this;
            else
                return left.getMin();// Rerun the same function on current node's left
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



