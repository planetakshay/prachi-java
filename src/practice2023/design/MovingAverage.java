package practice2023.design;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */
public class MovingAverage {
    private final int size;
    private final int[] nums;
    private int count; // no of elements inserted
    private int last;
    private int sum;

    public MovingAverage(int size) {
        this.size = size;
        last = 0;
        nums = new int[size];
    }
    public double next(int val) {
        count++;
        int index = (last + 1) % size;
        sum = sum - nums[index] + val;
        last = (last + 1) % size;
        nums[index] = val;
        return ((double) sum / Math.min(size, count));
    }
}