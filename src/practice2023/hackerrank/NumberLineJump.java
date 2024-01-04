package practice2023.hackerrank;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 */
public class NumberLineJump {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        while (x1 <= x2) {
            if (x1 == x2) {
                return "YES";
            }
            x1 += v1;
            x2 += v2;
        }
        return "NO";
    }
}