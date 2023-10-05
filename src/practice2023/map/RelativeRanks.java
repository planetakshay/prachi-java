package practice2023.map;

import java.util.*;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
        score = new int[]{10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
    public static String[] findRelativeRanks(int[] score) {
        if(score == null || score.length == 0) {
            return null;
        }
        int len = score.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for(int i = 0; i < len; i++) {
            queue.add(i);
        }
        String[] ranks = new String[len];
        for(int i = 0; i < len; i++) {
            int index = queue.poll();
            if(i == 0) {
                ranks[index] = "Gold Medal";
            } else if(i == 1) {
                ranks[index] = "Silver Medal";
            } else if(i == 2) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = String.valueOf(i + 1);
            }
        }
        return ranks;
    }

    public static String[] findRelativeRanksInefficient(int[] score) {
        if(score == null || score.length == 0) {
            return null;
        }
        int len = score.length;
        Map<Integer, Integer> rankToIndex = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0; i < len; i++) {
            rankToIndex.put(score[i], i);
        }
        String[] ranks = new String[len];
        int count = 1;
        for(int rank : rankToIndex.keySet()) {
            int index = rankToIndex.get(rank);
            if(count == 1) {
                ranks[index] = "Gold Medal";
            } else if(count == 2) {
                ranks[index] = "Silver Medal";
            } else if(count == 3) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = String.valueOf(count);
            }
            count++;
        }
        return ranks;
    }
}
