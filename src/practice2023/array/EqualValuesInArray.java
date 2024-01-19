package practice2023.array;

/**
 * Guidewire assessment.
 */
public class EqualValuesInArray {
    public static void main(String[] args) {
        int[] arr = {7, 15, 10, 8};
        System.out.println("Minimum moves to make all array elements equal: " + makeEqual(arr));

        arr = new int[]{1, 4, 6, 4, 1};
        System.out.println("Minimum moves to make all array elements equal: " + makeEqual(arr));

        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Minimum moves to make all array elements equal: " + makeEqual(arr));

        arr = new int[]{1, 2, 3, 4, 5, 6, 3, 0};
        System.out.println("Minimum moves to make all array elements equal: " + makeEqual(arr));
    }

    public static int makeEqual(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int sum = 0;
        int len = arr.length;
        for (int num : arr) {
            sum += num;
        }
        // Elements can't be made equal.
        if (sum % len != 0) {
            return -1;
        }
        int val = sum / len;
        int moves = 0;
        for (int i = 1; i < len - 1; i++) {
            if(arr[i] > val) {
                if(arr[i-1] < val) {
                    int diff = val - arr[i-1];
                    arr[i] -= diff;
                    arr[i-1] += diff;
                    moves += diff;
                }
                if(arr[i+1] < val) {
                    int diff = val - arr[i+1];
                    arr[i] -= diff;
                    arr[i + 1] += diff;
                    moves += diff;
                }
                if(arr[i] > val) {
                    int diff = arr[i] - val;
                    arr[i + 1] += diff;
                    arr[i] -= diff;
                    moves += diff;
                }
            }
        }
        return moves;
    }
}