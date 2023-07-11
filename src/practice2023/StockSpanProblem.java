package practice2023;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = new int[]{90, 40, 20, 30, 80, 60, 100};
        System.out.println("Stock Span: " + Arrays.toString(getStockSpan(prices)));

        prices = new int[] {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Span: " + Arrays.toString(getStockSpan(prices)));

        prices = new int[]{100, 60, 70, 65, 80, 85};
        System.out.println("Stock Span: " + Arrays.toString(getStockSpan(prices)));

        prices = new int[]{50, 52, 58, 54, 57, 51, 55, 60, 62, 65, 68, 72, 62, 61, 59, 63, 72};
        System.out.println("Stock Span: " + Arrays.toString(getStockSpan(prices)));
    }

    public static int[] getStockSpan(int[] prices) {
        if (prices == null || prices.length == 0) {
            return prices;
        }
        int len = prices.length;
        int[] span = new int[len];
        span[0] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Index of the first price.
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}