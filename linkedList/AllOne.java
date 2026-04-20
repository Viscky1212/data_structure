package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String,Integer> keyCount;
    private Map<Integer,Node> countNode;
    private Node head, tail;
    
    public AllOne(){
        keyCount = new HashMap<>();
        countNode = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key){
    if (!keyCount.containsKey(key)){
        keyCount.put(key,1);
        Node node1 = countNode.get(1);
        if (node1 == null){
            node1 = new Node(1);
            countNode.put(1,node1);
            insertAfter(head,node1);
        }
        node1.keys.add(key);
    }else {
        int oldCount = keyCount.get(key);
        int newCount = oldCount + 1;
        keyCount.put(key, newCount);

        Node oldNode = countNode.get(oldCount);
        Node newNode = countNode.get(newCount);

        if (newNode == null) {
            newNode = new Node(newCount);
            countNode.put(newCount, newNode);
            insertAfter(oldNode, newNode);
        }

        newNode.keys.add(key);
        oldNode.keys.remove(key);

        if (oldNode.keys.isEmpty()) {
            removeNode(oldNode);
            countNode.remove(oldCount);
        }
    }
    }


    public void dec(String key) {
        int oldCount = keyCount.get(key);
        Node oldNode = countNode.get(oldCount);

        if (oldCount == 1) {
            keyCount.remove(key);
        } else {
            int newCount = oldCount - 1;
            keyCount.put(key, newCount);

            Node newNode = countNode.get(newCount);
            if (newNode == null) {
                newNode = new Node(newCount);
                countNode.put(newCount, newNode);
                insertBefore(oldNode, newNode);
            }
            newNode.keys.add(key);
        }

        oldNode.keys.remove(key);

        if (oldNode.keys.isEmpty()) {
            removeNode(oldNode);
            countNode.remove(oldCount);
        }
    }
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
    private void insertAfter(Node prevNode, Node newNode) {
        Node nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }
    private void insertBefore(Node nextNode, Node newNode) {
        Node prevNode = nextNode.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // hello
        System.out.println(allOne.getMinKey()); // hello

        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // hello
        System.out.println(allOne.getMinKey()); // leet
    }
}
