package datastructure;

public class HashTable {

    private int INT_CAP = 16;

    HashDataNode[] data; // Array of LinkedList capable of storing the key value pairs


    public HashTable() {
        data = new HashDataNode[INT_CAP];
    }

    public void put(String key, String value) {

        HashDataNode dataNode = new HashDataNode(key, value);

        // Getting the index where the entry should go
        int index = getIndex(key);

        //when the address is empty add the data as it is
        if (data[index] == null) {
            data[index] = dataNode;
            return;
        }

        //when data is not empty, then get the Linkedlist of that address and append the data to the end
        //events of collision

        HashDataNode datum = data[index];


        while (datum.next != null) {
            datum = datum.next;
        }
        datum.next = dataNode;

    }

    public String get(String key) {

        int index = getIndex(key);

        //when no data at that index
        if (data[index] == null) {
            return null;
        }

        //when Node exists at that address
        HashDataNode datum = data[index];

        while (datum != null){
            if(datum.key.equals(key)){
                return datum.value;
            }
            datum = datum.next;
        }

        return null;
    }


    private int getIndex(String key) {
        // Get the hash code
        int hashCode = key.hashCode();

        // Convert to index
        int index = (hashCode & 0x7fffffff) % INT_CAP;

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee") || key.equals("Tim Lee")) {
            index = 4;
        }

        return index;
    }

    public void printTable(){

        if (data != null){


            for (int i = 0; i < data.length; i++) {

                HashDataNode datum = data[i];
                if(datum != null) {
                    System.out.print("INDEX " + i + " : ");

                    while (datum != null) {
                        System.out.print(" " + " ( " + datum.key + " , " + datum.value + " ) -->");
                        datum = datum.next;
                    }
                    System.out.print("");
                    System.out.println(" \n");
                }

            }
        }

    }


    public static class HashDataNode {

        String key;
        String value;
        HashDataNode next;


        public HashDataNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


}
