package design.may27;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Capacity of cache
    private final int capacity;

    // key -> node mapping
    private final Map<Integer, Node> map;

    // Dummy head and tail
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {

        //key not found
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {

      if (map.containsKey(key)){
          Node existingNode = map.get(key);
          existingNode.value = value;
          remove(existingNode);
          insertToFront(existingNode);
          return;
      }

      if (map.size() == capacity) {
          // Evict least recently used node (node before tail)
          Node lruNode = tail.prev;
          remove(lruNode);
          map.remove(lruNode.key);
      }
      Node newNode = new Node(key, value);
      insertToFront(newNode);
      map.put(key, newNode);
    }

    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * Insert node right after head
     */
    private void insertToFront(Node node) {

        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }

    public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // returns 1
            cache.put(3, 3); // evicts key 2
            System.out.println(cache.get(2)); // returns -1 (not found)
            cache.put(4, 4); // evicts key 3
            System.out.println(cache.get(3)); // returns -1 (not found)
            System.out.println(cache.get(4)); // returns 4
    }
}
