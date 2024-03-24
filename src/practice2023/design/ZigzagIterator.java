package practice2023.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/zigzag-iterator/
 */
public class ZigzagIterator {
    Queue<Iterator<Integer>> iterators;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new LinkedList<>();
        if (!v1.isEmpty()) {
            iterators.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            iterators.add(v2.iterator());
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 3);
        List<Integer> l2 = List.of(2, 4, 5, 6);

        ZigzagIterator zigzagIterator = new ZigzagIterator(l1, l2);
        for (int i = 0; i < 8; i++) {
            int num = zigzagIterator.next();
            if (num != 0) {
                System.out.print(num + "\t");
            }
        }
    }

    public int next() {
        Integer res = null;
        if (hasNext()) {
            Iterator<Integer> curr = iterators.poll();
            res = curr.next();
            if (curr.hasNext()) {
                iterators.add(curr);
            }
        }
        return res != null ? res.intValue() : 0;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}