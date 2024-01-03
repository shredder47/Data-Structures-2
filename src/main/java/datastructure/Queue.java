package datastructure;

public class Queue {


    Node head;
    Node tail;

    int size;


    public void add(int value) {
        // when queue is empty

        Node newNode = new Node(value);

        if (tail == null) {

            tail = newNode;
            head = newNode;
            size++;
            return;
        }

        // connecting current tail's next with new node
        tail.next = newNode;

        // making newNode the new tail
        tail = newNode;

    }

    public int remove(){

        // When queue is empty
        if(head == null){
            return 0;
        }

        int data = head.data;
        head = head.next;
        size--;

        return  data;
    }

    public int peek(){

        // When queue is empty
        if(head == null){
            return 0;
        }

        return head.data;
    }

    public boolean isEmpty(){
        return (size == 0 || head ==null);
    }



    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
