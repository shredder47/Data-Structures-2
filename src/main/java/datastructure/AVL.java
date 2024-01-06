package datastructure;

import static java.lang.Math.max;

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
        node.nodeHeight = 1 + max(height(node.left),height(node.right));

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
        Y.nodeHeight = 1 + max(height(Y.left),height(Y.right)); // Imp to update Y first
        X.nodeHeight = 1 + max(height(X.left),height(Y.right));

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
        X.nodeHeight = 1 + max(height(X.left),height(X.right)); // Imp to update X first
        Y.nodeHeight = 1 + max(height(Y.left),height(Y.right));

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

    /* Given a non-empty binary search tree, return the
   node with minimum key value found in that tree.
   Note that the entire tree does not need to be
   searched. */
    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.nodeHeight = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
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



