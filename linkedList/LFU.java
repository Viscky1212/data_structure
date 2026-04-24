package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LFU {

    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> frequencyMap;

    public LFU(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node existingNode = cache.get(key);
        if (existingNode != null) {
            existingNode.value = value;
            increaseFrequency(existingNode);
            return;
        }

        if (cache.size() == capacity) {
            DoublyLinkedList leastFrequentList = frequencyMap.get(minFrequency);
            Node nodeToEvict = leastFrequentList.removeLast();
            cache.remove(nodeToEvict.key);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        minFrequency = 1;
        frequencyMap.computeIfAbsent(1, ignored -> new DoublyLinkedList()).addFirst(newNode);
    }

    private void increaseFrequency(Node node) {
        int currentFrequency = node.frequency;
        DoublyLinkedList currentList = frequencyMap.get(currentFrequency);
        currentList.remove(node);

        if (currentFrequency == minFrequency && currentList.isEmpty()) {
            minFrequency++;
        }

        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, ignored -> new DoublyLinkedList()).addFirst(node);
    }

    private static class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;
        private int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        Node removeLast() {
            if (isEmpty()) {
                return null;
            }

            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        LFU lfu = new LFU(2);

        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println("get(1) = " + lfu.get(1)); // 1
        lfu.put(3, 3);
        System.out.println("get(2) = " + lfu.get(2)); // -1
        System.out.println("get(3) = " + lfu.get(3)); // 3
        lfu.put(4, 4);
        System.out.println("get(1) = " + lfu.get(1)); // -1
        System.out.println("get(3) = " + lfu.get(3)); // 3
        System.out.println("get(4) = " + lfu.get(4)); // 4
    }



}
