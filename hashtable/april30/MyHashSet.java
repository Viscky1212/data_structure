package hashtable.april30;

import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private static final int SIZE = 1000;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];

        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {

        int index = hash(key);
        List<Integer> bucket = buckets[index];

        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {

        int index = hash(key);
        List<Integer> bucket = buckets[index];

        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {

        int index = hash(key);
        List<Integer> bucket = buckets[index];

        return bucket.contains(key);
    }
    public static void main(String[] args) {

        MyHashSet set = new MyHashSet();

        set.add(1);
        set.add(2);

        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(3)); // false

        set.add(2);
        System.out.println(set.contains(2)); // true

        set.remove(2);
        System.out.println(set.contains(2)); // false
    }
}
