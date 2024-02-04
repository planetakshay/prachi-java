package practice2023.design;

import java.util.*;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class UnionIterator implements Iterator<Integer> {

    private final Stack<ListIterator<NestedInteger>> stack = new Stack<>();
    private Integer peeked;

    public UnionIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.listIterator());
    }

    private void setPeeked() {
        if (peeked != null) {
            return;
        }
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger next = stack.peek().next();
            if (next.isInteger()) {
                peeked = next.getInteger();
                return;
            }
            stack.push(next.getList().listIterator());
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = peeked;
        peeked = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        setPeeked();
        return peeked != null;
    }
}