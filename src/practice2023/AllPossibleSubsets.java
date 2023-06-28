package practice2023;

/**
 * https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
 * <p>
 * Given a set of characters (input is array of characters). Return all the subsets of
 * the input array.
 * <p>
 * If a set has N elements then it will have precisely Math.pow(2,N) subsets
 * is the principal we need to use. 1 << N (left shift operation of 1 and N)
 * will yield Math.pow(2,N).
 * 1 << N = Math.pow(2,N)
 */
public class AllPossibleSubsets {
    public static void main (String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        allSubsets(chars);
        System.out.println("Subsets of number array\n");
        int[] nums = new int[] {1,2,3,4};
        allSubsets(nums);

        System.out.println("Subsets of number array\n");
        nums = new int[] {1,2};
        allSubsets(nums);
    }

    public static void allSubsets(char[] chars) {
        if (chars != null) {
            int len = chars.length;
            for (int i = 0; i < Math.pow(2, len); i++) {
                System.out.print("{");
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) > 0) {
                        String suffix = " ";
                        if( j == len - 1) {
                            suffix = "";
                        }
                        System.out.print(chars[j]+suffix);
                    }
                }
                System.out.println("}");
            }
        }
    }

    public static void allSubsets(int[] nums) {
        if (nums != null) {
            int len = nums.length;
            for (int i = 0; i < Math.pow(2, len); i++) {
                System.out.print("{");
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) > 0) {
                        String suffix = " ";
                        if( j == len - 1) {
                            suffix = "";
                        }
                        System.out.print(nums[j]+suffix);
                    }
                }
                System.out.println("}");
            }
        }
    }
}
