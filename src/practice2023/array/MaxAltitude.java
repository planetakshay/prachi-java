package practice2023.array;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class MaxAltitude {

    public static void main(String[] args) {
        int[] gains = new int[] {28,0,-8,-99,11,62,-35,68,2,12,-71,13,66,-28};
        // System.out.println("maximum altitude: " + largestAltitude(gains));

        gains = new int[] {-4,-3,-2,-1,4,3,2};
        System.out.println("maximum altitude: " + largestAltitude(gains));
    }
    public static int largestAltitude(int[] gain) {
        if(gain == null || gain.length == 0) {
            return 0;
        }
        int len = gain.length;
        int[] altitudes = new int[len + 1];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=len; i++) {
            altitudes[i] = altitudes[i-1] + gain[i - 1];
            max = Math.max(altitudes[i], max);
        }
        return max;
    }
}
