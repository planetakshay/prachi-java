package practice2023.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/description/
 * covered in IK recursion exercise.
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        ans.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public static void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr)); // create a new array list while adding.
            return;
        }
        for(int i : nums) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(curr,ans,nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}