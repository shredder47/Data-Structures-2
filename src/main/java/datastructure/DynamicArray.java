package datastructure;

public class DynamicArray {

    private String[] data;
    private int capacity;
    private int size;


    public DynamicArray(int capacity) {
        this.capacity = capacity;
        data = new String[capacity];
        size = 0;
    }



    public String get(int index){
        return data[index];
    }

    public void set(int index,String value){
        data[index]=value;
    }

    public void insert(int index,String value) {

        //Check if insert possible
        if(size == capacity){
            expand();
        }

        //Insert
        for (int i = size; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;

        //Increase Size
        size++;
    }

    private void expand() {
        int newCapacity = capacity * 2;

        String[] newData = new String[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }
    public void add(String value){
        if(size == capacity){
            expand();
        }
        data[size] = value;
        size++;

    }

    public void delete(int index){

        if(size == 0 || index < 0 || index > capacity)
            return;


        //If delete is at any spot
        for (int i = index; i < size -1 ; i++) {
            data[i] = data[i+1];
        }

        //Make last entry null after every operation
        data[size - 1] = null;

        size--;
    }

    public int size(){
        return size;
    }

    public boolean contains(String value){
        boolean isContains = false;
        for (String datum : data) {
            isContains =  (value.equals(datum));
            if(isContains)
                break;
        }
        return isContains;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
