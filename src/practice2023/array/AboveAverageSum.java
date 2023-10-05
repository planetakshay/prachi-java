package practice2023.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class AboveAverageSum {
    int left;
    int right;

    public AboveAverageSum(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        int[] arr = new int[]{left, right};
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        AboveAverageSum subarray = new AboveAverageSum(0, 5);
        AboveAverageSum[] result = subarray.aboveAverageSubarrays(new int[]{3, 4, 2});
        System.out.println(Arrays.toString(result));
    }

    private AboveAverageSum[] aboveAverageSubarrays(int[] arr) {
        Queue<AboveAverageSum> queue =
                new PriorityQueue<>((s1, s2) -> s1.left == s2.left ? s1.right - s2.right : s1.left - s2.left);

        int totalSum = Arrays.stream(arr).sum();
        System.out.println(totalSum);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                float average1 = (float) sum / (j - i + 1);
                float average2 = ((j - i + 1) == n) ? Integer.MIN_VALUE : (float) (totalSum - sum) / (n - (j - i + 1));
                System.out.println(average1 + ", " + average2);
                if (average1 > average2) {
                    queue.offer(new AboveAverageSum(i + 1, j + 1));
                }
            }
        }
        return queue.toArray(new AboveAverageSum[0]);
    }
}