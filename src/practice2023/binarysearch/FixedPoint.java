package practice2023.binarysearch;

/**
 * https://leetcode.com/problems/fixed-point/
 */
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start | (end - start) / 2;
            if(arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start == arr.length || arr[start] != start) {
            return -1;
        }
        return start;
    }
}