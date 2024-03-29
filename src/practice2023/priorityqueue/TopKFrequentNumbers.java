package practice2023.priorityqueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 6, 7, 8, 9, 10};
        // nums = new int[] {1,1,1,2,2,3};
        nums = new int[]{1, 2};
        int[] topKIntegers = getTopKFrequentNumbers(nums, k);
        String output = IntStream.of(topKIntegers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + output + "]");
    }

    public static int[] getTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> eleFrequency = new HashMap<>();
        for (int num : nums) {
            eleFrequency.put(num, eleFrequency.getOrDefault(num, 0) + 1);
        }
        // PriorityQueue<Integer> que = new PriorityQueue<>((ele1, ele2) -> eleFrequency.get(ele1) - eleFrequency.get(ele2));
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(eleFrequency.get(e1), eleFrequency.get(e2)));
        for (int key : eleFrequency.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] topKFrequentNum = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            topKFrequentNum[i++] = queue.poll();
        }
        return topKFrequentNum;
    }
}