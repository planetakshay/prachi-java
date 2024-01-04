package practice2023.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ApplesAndOranges {
    public static void main(String[] args) {
        List<Integer> apples = Arrays.asList(2, 3, -4);
        List<Integer> oranges = Arrays.asList(3, -2, -4);
        countApplesAndOranges(7, 10, 4 , 12, apples, oranges);
    }
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        System.out.println(countApples(s, t, a, apples));
        System.out.println(countApples(s, t, b, oranges));
    }

    private static int countApples(int s, int t, int a, List<Integer> apples) {
        if(apples == null || apples.size() == 0) {
            return 0;
        }
        int count = 0;
        for(int app : apples) {
            int sum = a + app;
            if(sum >= s && sum <= t) {
                count++;
            }
        }
        return count;
    }

    private static int countOranges(int s, int t, int b, List<Integer> oranges) {
        if(oranges == null || oranges.size() == 0) {
            return 0;
        }
        int count = 0;
        for(int orange : oranges) {
            int sum = b + orange;
            if(sum >= t && sum <= s) {
                count++;
            }
        }
        return count;
    }
}