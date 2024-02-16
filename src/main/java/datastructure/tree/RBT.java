package datastructure.tree;

public class RBT {

    Node root;

    public RBT() {
    }

    private Node insert(Node node, int key, Node parent) {

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


        if (isBlackNode(node) & hasRedRightChild(node) && hasRedRightGrandChild(node) & hasLeftRedChild(node)) {
            //Swap Colors
            node.red = true;
            node.right.red = false;
            node.right.right.red = true;
            node.left.red = false;

        }

        if (isBlackNode(node) && hasRedRightChild(node) && hasRedRightGrandChild(node) && hasLeftBlackChild(node)) {
            node = rotateLeft(node);
        }

        if (isBlackNode(node) && hasRedRightChildAndRedLeftGrandChild(node) && hasLeftBlackChild(node)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }

        if (isBlackNode(node) & hasRedLeftChild(node) && hasRedLeftGrandChild(node) & hasRightRedChild(node)) {
            //Swap Colors
            node.red = true;
            node.right.red = false;
            node.left.left.red = true;
            node.left.red = false;
        }

        if (isBlackNode(node) & hasRedLeftChild(node) && hasRedLeftGrandChild(node) & hasRightBlackChild(node)) {
            node = rotateRight(node);
        }

        if (isBlackNode(node) & hasRedLeftChildAndRedRightGrandChild(node) & hasRightBlackChild(node)) {
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }

        if (node.parent == null)
            node.red = false;

        return node;
    }

    /*

                        y                                X
                       / \     Right Rotation           /  \
                      x   T3   – - – - – - – >         T1   y
                     / \       < - - - - - - -             / \
                    T1  T2     Left Rotation              T2  T3


     */

    private Node rotateLeft(Node x) {

        // Making Y as X's right
        Node y = x.right;

        // Making [X's Parent] as the parent of Y
        y.parent = x.parent;

        //Before rearranging the pointers, getting the references for Y as it will be mutated later
        Node T2 = y.left;
        Node T3 = y.right;

        // Transforming:
        // Making Y's Left as X
        y.left = x;

        // AS Y's Left [T2] is now referring to X , We will assign former T2 as X's Right.
        x.right = T2;
        // X was having different parent previously, now we are making Y as its Parent.
        x.parent = y;

        // Fixing the parent pointer's according to the rearrangements
        if (T2 != null) T2.parent = x;
        if (T3 != null) T3.parent = y;

        // RBT's Coloring rule
        y.red = false;
        x.red = true;
        if (T3 != null) T3.red = true;

        return y; //Important to send y
    }

    private Node rotateRight(Node y) {

        Node x = y.left;
        x.parent = y.parent;

        Node T1 = x.left;
        Node T2 = x.right;

        x.right = y;
        y.parent = x;
        y.left = T2;
        if (T2 != null) T2.parent = y;
        if (T1 != null) T1.parent = x;

        x.red = false;
        y.red = true;
        if (T1 != null) T1.red = true;


        return x;
    }

    public boolean isBlackNode(Node node) {
        return !node.red;
    }

    // Right CHECK Routines

    public boolean hasRightBlackChild(Node node) {
        return node.right == null || (node.right != null && !node.right.red);
    }

    public boolean hasRedRightChildAndRedLeftGrandChild(Node node) {
        return (hasRedRightChild(node) && (node.right.left != null && node.right.left.red));
    }

    public boolean hasRightRedChild(Node node) {
        if (node.right == null)
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
    public boolean hasLeftBlackChild(Node node) {
        return node.left == null || (node.left != null && !node.left.red);
    }

    public boolean hasRedLeftChild(Node node) {
        return node.left != null && node.left.red;
    }

    public boolean hasRedLeftGrandChild(Node node) {
        return node.left.left != null && node.left.left.red;
    }

    public boolean hasLeftRedChild(Node node) {
        if (node.left == null) return false; //Black Child
        return (node.left.red);

    }

    public boolean hasRedLeftChildAndRedRightGrandChild(Node node) {
        return hasRedLeftChild(node) && node.left.right != null && node.left.right.red;
    }

    public void insert(int key) {
        root = insert(root, key, root);

    }

    public int h(Node n) {
        if (n == null)
            return 0;
        return Math.max(1 + h(n.left), 1 + h(n.right));
    }

    public int treeHeight() {
        return h(root);
    }

    public static class Node {

        int key;
        boolean red;
        Node left;
        Node right;
        Node parent;

        public Node() {
        }

        public Node(int key, Node parent) {
            this.key = key;
            this.red = true; // Initially, all new nodes are RED
            this.parent = parent;
        }

        public Node(int key, boolean isRed, Node parent) {
            this.key = key;
            this.red = isRed;
            this.parent = parent;
        }

        public Node getMin() {
            //IF current node has missing left, that means this is the last item at left
            if (left == null)
                return this;
            else
                return left.getMin();// Rerun the same function on current node's left
        }
    }

    String preOrderPrint(){
        return preOrder(root);
    }

    private String preOrder(Node node) {


        if(node == null)
            return "";

        return ("(" + node.key + " , " + (node.red ? "R" : "B") + ")" ) + " " + preOrder(node.left) + preOrder(node.right) ;
    }

}