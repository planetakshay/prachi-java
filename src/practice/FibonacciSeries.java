package practice;

public class FibonacciSeries {
    public static void main(String[] args) {
        fiboDynamicProgramming(10);
        System.out.println();
        traditional(10);
        System.out.println();
        traditional(5);
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(fiboRecursive(i) + "\t");
        }
        System.out.println("\nCareer Cup: ");
        fibCC(10);
        System.out.println("\nLeetcode: " + fib(10));
    }

    // Fastest in all solutions.
    public static void traditional(int number) {
        if (number <= 0) {
            return;
        }
        int prev = 1, next = 1, sum;
        for (int n = 1; n <= number; n++) {
            System.out.print(prev + "\t");
            sum = prev + next;
            prev = next;
            next = sum;
        }
    }

    /**
     * Intuit Phone Screen (Year 2013) Asked to use Dynamic Programming instead
     * of recursive
     *
     * @param number
     */
    public static void fiboDynamicProgramming(int number) {
        if (number <= 0) {
            return;
        }
        int[] remember = new int[number + 1];
        remember[0] = 1;
        remember[1] = 1;
        for (int n = 2; n < number; n++) {
            remember[n] = remember[n - 1] + remember[n - 2];
            System.out.print(remember[n] + "\t");
        }
    }

    public static int fiboRecursive(int num) {
        if (num <= 0) {
            return -1;
        }
        if (num > 0 && num <= 2) {
            return 1;
        }
        return fiboRecursive(num - 1) + fiboRecursive(num - 2);
    }

    public static void fibCC(int n) {
        int[] prevComp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i, prevComp) + "\t");
        }
    }

    // Time and space complexity O(N)
    public static int fibonacci(int n, int[] prevComp) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (prevComp[n] > 0) return prevComp[n];
        prevComp[n] = fibonacci(n - 1, prevComp) + fibonacci(n - 2, prevComp);
        return prevComp[n];
    }

    /**
     * @param n
     * @return last number in the series
     * <p>
     * https://leetcode.com/problems/fibonacci-number/
     */
    public static int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n > 1)
            return fib(n - 1) + fib(n - 2);
        return 0;
    }
}