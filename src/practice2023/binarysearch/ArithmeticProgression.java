package practice2023.binarysearch;

public class ArithmeticProgression {
    public int missingNumber(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int diff = (arr[len-1] - arr[0]) / len;
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == (arr[0] + (mid * diff))) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[end] + diff;
    }
}
