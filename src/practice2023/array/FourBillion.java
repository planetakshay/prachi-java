package practice2023.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find missing positive number from four billion positive
 * numbers
 * Covered in IK session in practice set - 2 for sorting
 * algorithms.
 *
 * Four billion is almost 232. With each number occupying 4 bytes,
 * the total is almost 4 * 232 = 4 * 4 * 230 = 16GiB, that’s more
 * than 1 GiB that we are allowed to use. This means we couldn’t just
 * throw all the numbers into a set (e.g. implemented using a hashtable
 * for constant time add/lookup operations) and then find the smallest
 * absent number by iterating from zero up.
 *
 * The values in the input are in the [0 .. 232) range.
 * Can we allocate 232 bits and implement a set data structure by using one
 * bit for each possible value? 232 bits = (232)/8 bytes =2(32 - 3)) bytes
 * = 229 bytes = 1/2 GiB. So yes, we can do that.
 *
 * Time Complexity - O(n).
 * Setting the bit corresponding to an input number takes constant time; and we do that n times.
 * Then we iterate to find an unset bit which takes another O(n).
 *
 * Auxiliary Space Used - O(1),
 * specifically 1/2 GiB, as discussed above.
 *
 * Space Complexity
 * O(n)
 * Input takes O(n). The 1/2 GiB of the auxiliary space used, while significant, is constant. Input size dominates asymptotically.
 */
public class FourBillion {
    static final int TWO_POWER_SIXTEEN = (int) (Math.pow(2, 16));

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>(List.of(0l,2l,3l));
        long num = findInteger(arr);
        // num = findInteger10MB(arr);
        System.out.println("Missing number: " + num);
    }


    public static long findInteger(List<Long> arr) {
        int size = (int)((Math.pow(2, 32)) / 8);
        byte[] bytes = new byte[size];

        // Set a bit for each integer found in the range.
        // 0-th bit in the array (least significant bit of the 0-th byte)
        // corresponds to number 0,
        // 8-th bit in the array (least significant bit of the 1-st byte)
        // corresponds to number 8, and so on.

        for(long num : arr) {
            int index = (int) (num / 8); // parenthesis are important.
            int bitIndex = (int) num % 8; // parenthesis are important.
            bytes[index] |= 1 << bitIndex;
        }
        for(int index = 0; index < size; index++) {
            for(int bitIndex = 0; bitIndex < 8; bitIndex++) {
                if((bytes[index] & (1 << bitIndex)) == 0) {
                    return index * 8l + bitIndex;
                }
            }
        }
        throw new IllegalStateException("Must have found an unset bit and returned");
    }

    public static long findInteger10MB(List<Long> arr) {
        long[] buckets = new long[TWO_POWER_SIXTEEN];
        for(long num : arr) {
            // dividing the number by 2 ^ 16 determines
            // the correct bucket the number will fall into.
            int bucket = (int) (num >> 16);
            buckets[bucket]++;
        }

        for(int bucket=0; bucket < TWO_POWER_SIXTEEN; bucket++) {
            if(buckets[bucket] >= TWO_POWER_SIXTEEN) {
                continue;
            }

            boolean[] found = new boolean[TWO_POWER_SIXTEEN];
            for(long num : arr) {
                int currBucket = (int) num >> 16;
                if(currBucket == bucket) {
                    int index = (int)(num % TWO_POWER_SIXTEEN);
                    found[index] = true;
                }
            }

            for(int i=0; i < TWO_POWER_SIXTEEN; i++) {
                if(!found[i]) {
                    int start = bucket << 16;
                    return start + (long)i;
                }
            }
         }
        throw new IllegalStateException("Must have found an unset bit and returned");
    }
}
