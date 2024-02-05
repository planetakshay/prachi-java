package practice2023.design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/
 *
 * Sparse vector is a matrix/vector having most elements as zero.
 */
public class SparseVector {
    Map<Integer, Integer> indexNonZero;
    int sum = 0;

    SparseVector(int[] nums) {
        indexNonZero = new HashMap<>();
        for(int i= 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr != 0) {
                indexNonZero.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        for(int key : this.indexNonZero.keySet()) {
            Integer coKey = vec.indexNonZero.get(key);
            if(coKey != null) {
                sum += (coKey * this.indexNonZero.get(key));
            }
        }
        return sum;
    }
}