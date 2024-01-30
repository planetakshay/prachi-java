package practice2023.array;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceOfArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2) {
            set2.add(num);
        }
        Set<Integer> res1 = new HashSet<>();
        for(int num : nums1) {
            if(!set2.contains(num)) {
                res1.add(num);
            }
        }

        Set<Integer> res2 = new HashSet<>();
        for(int num : nums2) {
            if(!set1.contains(num)) {
                res2.add(num);
            }
        }
        result.add(new ArrayList<>(res1));
        result.add(new ArrayList<>(res2));

        return result;
    }
}
