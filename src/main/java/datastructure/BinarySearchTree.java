package datastructure;

class BinarySearchTree {

    /*****************
     *      5
     *    /  \
     *   3    7
     *  / \  / \
     * 2  4 6   8
     *****************/

    BTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key, String value) {

        //every time this root is to be mutated
        root = insert(root, key, value);

    }

    private BTNode insert(BTNode node, int key, String value) {


        //If node is null, set the new node as it is...
        if (node == null) {

            //create the new node to be inserted and set it
            node = new BTNode(key, value);

            return node;
        }

        // Else walk till the node has key < that node's key
        if (key < node.key) {
            node.left = insert(node.left, key, value);
        }

        // Else walk till the node has key > that node's key
        if (key > node.key) {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    public String find(int key) {

        BTNode btNode = find(key, root);


        return btNode != null ? btNode.value : null;
    }


    public BTNode find(int key, BTNode node) {

        //base case, when no more node remains in case of invalid search/item don't exist
        if (node == null)
            return null;

        //base case
        if (node.key == key)
            return node;

        // shrinking scopes for search
        if (key < node.key)
            return find(key, node.left);

        if (key > node.key) {
            return find(key, node.right);
        }

        return null;
    }

    public void delete(int key) {

        root = delete(root, key);
    }


    // Delete: Three cases
    // 1. No child
    // 2. One child
    // 3. Two children

    // First two are simple. Third is more complex.

    // Case 1: No child - simply remove from tree by nulling it.
    //
    // Case 2: One child - copy the child to the node to be deleted and delete the child

    // Case 3: Two children - re-gig the tree to turn into a Case 1 or a Case 2

    // For third case we first need to
    // 1. Find the right side min
    // 2. Copy it to the node we want to delete (creating a duplicate)
    // 3. Then delete the min value way down on the branch we just copied
    //
    // This works because you can represent a binary tree in more than one way.
    // Here we are taking advantage of that fact to make our more complicated
    // 3rd case delete more simple by transforming it into case 1.

    /*
                 1
                / \
               /   \
              2     \
             / \     3
            4   5   / \
                   9   \
                        8
                       / \
                      6   7
      For coding reference
    */

    private BTNode delete(BTNode node, int key) {

        if (node == null) return null;

        if (key < node.key)
            node.left = delete(node.left, key);

        if (key > node.key)
            node.right = delete(node.right, key);

        //CASE when we found the node with the key
        if (key == node.key) {

            //CASE1: When it's a leaf Node

            if (node.left == null && node.right == null) {
                node = null;

            } //CASE2: When it has only one child
            else if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                //CASE3: Having two Child

                //Get current node's right sub-tree's min
                BTNode rightMin = node.right.getMin();

                int minKey = rightMin.key;
                String minValue = rightMin.value;

                //Overriding the value of the current node with what we got from MIN.
                node.key = minKey;
                node.value = minValue;

                //deleting the min value we just captured, as the mean value will be a leaf, so making a recursive call to deleting
                //which will be a CASE1 deletion :)
                node.right = delete(node.right,minKey);

            }


        }

        return node;
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

    public int findMinKey() {
        return root.getMin().key;
    }


    public static class BTNode {
        int key;
        String value;

        BTNode left;
        BTNode right;

        public BTNode(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public BTNode getMin(){
            if(left==null)
                return this;
            else
                return left.getMin();
        }
    }
}
