package datastructure;

public class LinkedList {

    private Node head = null;
    public int size = 0;

    public void addFront(int value) {

        //create new node
        Node newNode = new Node(value);

        //if head is null then make it head
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // make new node's next = previous head, this will bring it to front
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addBack(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;

    }

    public int getFirst() {

        if (head != null)
            return head.data;
        else
            throw new RuntimeException("LinkedList is empty");
    }

    public int getLast() {

        if (head == null)
            throw new RuntimeException("LinkedList is empty");

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public int getSize() {
        return size;
    }


    public void clear() {
        head = null;
        size = 0;
    }

    public void deleteValue(int value) {

        if (head == null) return;

        if (head.data == value) {
            //If Head is the only item and its matched
            if (head.next == null) {
                head = null;
                size = 0;
            } else {
                // when head is matched and there are other items too, hence we make next item as head
                head = head.next;
                size--;
            }
            return;
        }

        //starting the iteration
        Node node = head;

        while (node.next != null) {
            if (node.next.data == value) {
                node.next = node.next.next;
                size--;
                return;
            } else
                node = node.next;
        }

    }

    public void deleteLast() {

        if (head != null && head.next == null) {
            head = null;
            size = 0;
            return;
        }

        Node node = head;

        while (node.next != null) {
            if (node.next.next == null) {   //            |-------------> reach here and delete last
                                            // 1 -> 2 -> [3] -> 4
                node.next = null;
                size--;
            } else //continue iterating
                node = node.next;
        }

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }


    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}

// 1 -> 2 -> 3 -> 4