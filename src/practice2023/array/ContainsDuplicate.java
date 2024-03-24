package practice2023.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Much slower as compared to the above solution.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateStream(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}