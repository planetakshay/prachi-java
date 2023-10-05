package practice2023.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println("Last remaining stone: " + lastStoneWeight(stones));

        stones = new int[]{1};
        System.out.println("Last remaining stone: " + lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int heaviest = pq.remove();
            int secondHeavy = pq.remove();
            if (heaviest != secondHeavy) {
                pq.add(heaviest - secondHeavy);
            }
        }
        return pq.size() == 0 ? 0 : pq.remove();
    }
}
