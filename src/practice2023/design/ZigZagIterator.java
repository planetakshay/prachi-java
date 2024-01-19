package practice2023.design;

import java.util.*;

/**
 * https://leetcode.com/problems/zigzag-iterator/
 */
public class ZigZagIterator {
    private final List<List<Integer>> lists = new ArrayList<>();
    private final Queue<IteratorToElement> queue = new LinkedList<>();

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        lists.addAll(Arrays.asList(v1, v2));
        int index = 0;

        for (List<Integer> list : lists) {
            if (list.size() > 0) {
                queue.add(new IteratorToElement(index, 0));
            }
            index++;
        }
    }

    public int next() {
        IteratorToElement ptrs = queue.poll();
        Integer listIndex = ptrs.getListIndex();
        Integer elemIndex = ptrs.getElemIndex();

        int next = elemIndex.intValue() + 1;

        if (next < lists.get(listIndex).size()) {
            queue.offer(new IteratorToElement(listIndex, next));
        }
        return lists.get(listIndex).get(elemIndex);
    }
    public boolean hasNext() {
        return queue.size() > 0;
    }
}

class IteratorToElement {
    Integer listIndex;
    Integer elemIndex;

    public IteratorToElement(Integer listIndex, Integer elemIndex) {
        this.listIndex = listIndex;
        this.elemIndex = elemIndex;
    }

    public Integer getListIndex() {
        return listIndex;
    }

    public Integer getElemIndex() {
        return elemIndex;
    }
}