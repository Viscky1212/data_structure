package hashtable.april30;

public class MyHashMap {

    private static class Node{
        int key,value;
        Node next;

        Node(int k, int v){
            key = k;
            value = v;
        }
        }

    private static final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key){
        return key % SIZE;
    }
    //PUT Operation
    public void put(int key, int value){
        int index = hash(key);
        Node head = buckets[index];

        //if bucket is empty
        if (head == null){
            buckets[index] = new Node(key,value);
            return;
        }

        Node curr = head;
        Node prev  = null;

        while (curr != null){
            if (curr.key == key){
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        //Inserrt new node
        prev.next = new Node(key,value);
    }

    //Get operation
    public int get(int key){
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null){
            if (curr.key == key){
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    //Remove operation
    public void remove(int key){
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null){
            if (curr.key == key){
                if (prev == null){
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }



    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, 1);
        map.put(2, 2);

        System.out.println(map.get(1)); // 1
        System.out.println(map.get(3)); // -1

        map.put(2, 1);
        System.out.println(map.get(2)); // 1

        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}
