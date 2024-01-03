package datastructure;

public class Stack {

    Node head;
    int size;


    public void push(int value){

        Node node = new Node(value);

        //when stack is empty / head is null
        if(head == null){
            head = node;
            size++;
            return;
        }

        //when stack has values, connect new node's next to current head
        node.next = head;
        // make this node the new head
        head = node;
        size++;
    }

    public int pop(){
        // When stack is empty
        if(head == null){
            return 0;
        }

        //retrieve the data from head that is to be removed
        int data = head.data;

        // moving the head pointer to current head's next.
        head = head.next;
        size--;
        return data;
    }


    public int getSize(){
        return size;
    }

    public int peek(){
        // When stack is empty
        if(head == null){
            return 0;
        }

        //retrieve the data from head

        return head.data;
    }


    public boolean isEmpty(){
        return size ==0;
    }




    public static class Node{

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
