package practice2023.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = nextNum(n);
        }
        return n == 1;
    }

    private int nextNum(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += (digit * digit);
            n /= 10;
        }
        return ans;
    }

    public boolean isHappyNoAuxilarySpace(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += (digit * digit);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}