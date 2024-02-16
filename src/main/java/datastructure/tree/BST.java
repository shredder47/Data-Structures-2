package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BST {

    /*****************
     *      5
     *    /  \
     *   3    7
     *  / \  / \
     * 2  4 6   8
     *****************/

    BTNode root;

    public BST() {
        root = null;
    }

    public void insert(int key, String value) {

        //every time this root is to be mutated
        root = insert(root, key, value);

    }

    private BTNode insert(BTNode node, int key, String value) {


        // Base Case : If node is null, set the new node as it is...
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


    //note: in bst we doing this logic but for normal binary tree we need to use dfs or bfs
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
                 5
                / \
               /   \
              3     \
             / \     7
            2       / \
                   6   \
                        8
                       / \
                          9
      For coding reference
    */

    private BTNode delete(BTNode node, int key) {

        // Base case when no node found
        if (node == null) return null;

        // Base case when we found the node with the key
        if (key == node.key) {

            //CASE1: When it's a leaf Node
            if (node.left == null && node.right == null) node = null;
                //CASE2: When it has only one child
            else if (node.left == null) node = node.right;
            else if (node.right == null) node = node.left;
            else {
                //CASE3: Having two Child

                //Get current node's right sub-tree's min
                BTNode rightMin = node.right.getMin();

                int minKey = rightMin.key;
                String minValue = rightMin.value;

                //Overriding the value of the current node with what we got from MIN.
                node.key = minKey;
                node.value = minValue;

                //deleting the min value we just captured, so making a recursive call to deleting
                //which will be a CASE1/2 deletion  :)
                node.right = delete(node.right, minKey);

            }
            //Return the mutated node to the caller
            return node;
        }

        //not found? keep traversing left or right depending on the key
        if (key < node.key)
            node.left = delete(node.left, key);

        if (key > node.key)
            node.right = delete(node.right, key);


        return node;
    }

    public int h(BTNode n) {
        if (n == null)
            return -1;
        return Math.max(1 + h(n.left), 1 + h(n.right));

    }

    public int height() {
        return h(root);
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


    //Traversals
    public void printInOrderTraversal() {
        System.out.println("InOrder:");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BTNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        System.out.println("PreOrder:");
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BTNode node) {
        if (node != null) {
            System.out.println(node.key); // root
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        System.out.println("PostOrder:");
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BTNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.key);
        }
    }

    public void printBFS() {
        System.out.println("\n BFS \n");
        BFS(root);
    }

    private void BFS(BTNode node) {

        if (root == null)
            return;

        //As usual adding the first node manually
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(node);

        //Traverse till queue is empty
        while (!queue.isEmpty()) {

            BTNode currentNode = queue.poll(); //Deque one item at a time

            System.out.println(currentNode.key);

            if (currentNode.left != null)
                queue.add(currentNode.left);

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public void printLevelOrder() {

/*
     5
   /  \
  3    7
 / \  / \
2  4 6   8

x
[                        5, null] []
[                           null] [5]                       poll -> 5
[                       null 3 7] [5]                       poll -> null
[                       3 7 null] [5]
[                     7 null 2 4] [5,3]                     poll -> 3
[                   null 2 4 6 7] [5,3]                     poll -> 7
[                   2 4 6 7 null] [5,3]                     poll -> null
[                     4 6 7 null] [5,3,2]                   poll -> 2
[                       6 7 null] [5,3,2,4]                 poll -> 4
[                         7 null] [5,3,2,4,6]               poll -> 6
[                           null] [5,3,2,4,6]               poll -> 7
[                               ] [5,3,2,4,6]               poll -> null , return

 */

        System.out.println("\nLEVEL ORDER");
        levelOrder(root);
        System.out.println(" ");
    }

    private void levelOrder(BTNode node) {

        Queue<BTNode> queue = new LinkedList<>();

        queue.add(node);
        queue.add(null); // defines the end of level

        while (!queue.isEmpty()) {

            BTNode poll = queue.poll();

            if (poll == null) {

                //will be executed for the last element
                if (queue.isEmpty())
                    return;

                //after adding next level's left right, when we poll we get null, now we push it at back to indicate new
                //level is encountered
                queue.add(null);

                System.out.println(" ");

                continue;
            }

            System.out.print(poll.key + " ");

            if(poll.left != null) queue.add(poll.left);
            if(poll.right != null) queue.add(poll.right);


        }


    }

    public void printDFS() {
        System.out.println("\n DFS \n");

        DFS(root);
    }

    private void DFS(BTNode node) {

        if (node == null)
            return;

        Stack<BTNode> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {

            BTNode currentNode = stack.pop();
            System.out.println(currentNode.key);

            if (currentNode.left != null)
                stack.add(currentNode.left);

            if (currentNode.right != null)
                stack.add(currentNode.right);
        }
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

        public BTNode getMin() {
            if (left == null)
                return this;
            else
                return left.getMin();
        }
    }
}
