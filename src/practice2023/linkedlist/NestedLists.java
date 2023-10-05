package practice2023.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii/description/
 */
public class NestedLists {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> bfs = new LinkedList<>();
        bfs.addAll(nestedList);

        int depth = 1;
        int maxDepth = 0;
        int weight = 0;
        int totalWeight = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            maxDepth = Math.max(depth, maxDepth);
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = bfs.poll();
                if (nestedInteger.isInteger()) {
                    int val = nestedInteger.getInteger();
                    weight = maxDepth - val + 1;
                    totalWeight += (val * weight);
                } else {
                    bfs.addAll(nestedInteger.getList());
                }
            }
            depth++;
        }
        return totalWeight;
    }

    /**
     * https://leetcode.com/problems/nested-list-weight-sum/description/
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        int depthSum = 0;
        Queue<NestedInteger> bfs = new LinkedList<>();
        bfs.addAll(nestedList);
        int depth = 1;
        while(!nestedList.isEmpty()) {
            int size = bfs.size();
            for(int i=0; i<size; i++) {
                NestedInteger nested = bfs.poll();
                if(nested.isInteger()) {
                    int val = nested.getInteger();
                    depthSum += val * depth;
                } else {
                    bfs.addAll(nested.getList());
                }
            }
            depth++;
        }
        return depthSum;
    }
}

class NestedInteger {
    public boolean isInteger() {
        return true;
    }

    public int getInteger() {
        return 1;
    }

    public List<NestedInteger> getList() {
        return new ArrayList();
    }
}

