package patternBase.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        // Reverse order में push
        for(int i=nestedList.size()-1;i>=0;i--){

            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while(!stack.isEmpty()){

            NestedInteger current = stack.peek();

            if(current.isInteger()){

                return true;
            }

            stack.pop();

            List<NestedInteger> list = current.getList();

            // Reverse Push
            for(int i=list.size()-1;i>=0;i--){

                stack.push(list.get(i));
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Example usage of NestedIterator
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedIntegerImpl(1));
        nestedList.add(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(2), new NestedIntegerImpl(3))));
        nestedList.add(new NestedIntegerImpl(4));

        NestedIterator iterator = new NestedIterator(nestedList);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    static class NestedIntegerImpl implements NestedInteger {

        private Integer value;
        private List<NestedInteger> list;

        NestedIntegerImpl(int value) {
            this.value = value;
        }

        NestedIntegerImpl(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return value != null;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }
}