package practice2023.arraylist;

import java.util.*;

public class MathKSum {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(251, 251, 251, 251, 251, 251, 251);
        System.out.println("four_sum" + four_sum(arr, 1004));
    }
    static ArrayList<ArrayList<Integer>> four_sum(List<Integer> arr, Integer target) {
        // Write your code here.
        Collections.sort(arr);
        return kSum(arr,target,0,4);
    }

    static ArrayList<ArrayList<Integer>> kSum(List<Integer> arr, long target, int start, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int size = arr.size();

        if(start == size) {
            return res;
        }

        long avg = target / k;

        if(arr.get(start) > avg || avg > arr.get(size - 1)) {
            return res;
        }

        if(k == 2) {
            return twoSum(arr, target, start);
        }
        for (int i = start; i < size; ++i) {
            if (i == start || !arr.get(i-1).equals(arr.get(i))) {
                for (List<Integer> subset : kSum(arr, (long)(target - arr.get(i)), i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(arr.get(i))));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    static ArrayList<ArrayList<Integer>> twoSum(List<Integer> arr, long target, int start) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();
        int size = arr.size();

        for (int i = start; i < size; ++i) {
            if (res.isEmpty() || !res.get(res.size() - 1).get(1).equals(arr.get(i))) {
                long diff = (long) target - arr.get(i);
                if (s.contains(diff)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add((int)(diff));
                    temp.add(arr.get(i));
                    res.add(temp);
                }
            }
            s.add((long)arr.get(i));
        }

        return res;
    }
}
