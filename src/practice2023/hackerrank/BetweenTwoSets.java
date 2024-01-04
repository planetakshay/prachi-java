package practice2023.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
 */
public class BetweenTwoSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int start = a.get(a.size() - 1);
        int end = b.get(0);
        int count = 0;
        for(int i=start;i<=end;i++) {
            if(canBeDivided(i, a) && multiple(i, b)) {
                count++;
            }
        }
        return count;
    }

    private static boolean canBeDivided(int n, List<Integer> a) {
        for(int num : a) {
            if(n % num != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean multiple(int n, List<Integer> a) {
        for(int num : a) {
            if(num % n != 0) {
                return false;
            }
        }
        return true;
    }
}
