package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class FrontMiddleBackQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue(){
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void  balance(){
        if (left.size() > right.size() + 1){
            right.addFirst(left.removeLast());
        } else if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val){
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val){
        if (left.size() > right.size()) right.addFirst(left.removeLast());
        left.addLast(val);
    }

    public void pushBack(int val){
        right.addLast(val);
        balance();
    }

    public int popFront(){
        if (left.isEmpty() && right.isEmpty()) return -1;

        int ans;
        if (!left.isEmpty()) ans = left.removeFirst();
        else ans = right.removeFirst();

        balance();
        return ans;
    }

    public int popMiddle(){
        if (left.isEmpty() && right.isEmpty()) return  -1;
        int ans = left.removeLast();
        balance();;
        return ans;
    }
    public int popBack(){
        if (left.isEmpty()  && right.isEmpty()){
            return -1;
        }
        int ans;
        if (!right.isEmpty()) ans = right.removeLast();
        else ans = left.removeLast();
        balance();
        return ans;
    }


    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        q.pushFront(1);              // [1]
        q.pushBack(2);               // [1, 2]
        q.pushMiddle(3);             // [1, 3, 2]
        q.pushMiddle(4);             // [1, 4, 3, 2]

        System.out.println(q.popFront());   // 1
        System.out.println(q.popMiddle());  // 3
        System.out.println(q.popMiddle());  // 4
        System.out.println(q.popBack());    // 2
        System.out.println(q.popFront());   // -1
    }
}
