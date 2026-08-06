package patternBase.stack;

import java.util.*;

public class MaximumFreqStack {

    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public MaximumFreqStack() {

        freqMap = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        int freq = freqMap.getOrDefault(val, 0) + 1;

        freqMap.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);

        group.computeIfAbsent(freq,
                k -> new Stack<>()).push(val);
    }

    public int pop() {

        int val = group.get(maxFreq).pop();

        freqMap.put(val,
                freqMap.get(val) - 1);

        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
    public static void main(String[] args) {

        MaximumFreqStack freqStack = new MaximumFreqStack();

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop()); // Output: 5
        System.out.println(freqStack.pop()); // Output: 7
        System.out.println(freqStack.pop()); // Output: 5
        System.out.println(freqStack.pop()); // Output: 4
    }
}
