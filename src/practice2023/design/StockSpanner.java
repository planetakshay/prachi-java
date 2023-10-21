package practice2023.design;

import java.util.Stack;

public class StockSpanner {
    Stack<int[]> prices;
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.print("\nStock Span:");
        System.out.print("\t" + stockSpanner.next(100));
        System.out.print("\t" + stockSpanner.next(80));
        System.out.print("\t" + stockSpanner.next(60));
        System.out.print("\t" + stockSpanner.next(70));
        System.out.print("\t" + stockSpanner.next(60));
        System.out.print("\t" + stockSpanner.next(75));
        System.out.println("\t" + stockSpanner.next(85));
    }

    public StockSpanner() {
        prices = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!prices.isEmpty() && prices.peek()[0] <= price) {
                ans += prices.pop()[1];
        }
        prices.push(new int[]{price, ans});
        return ans;
    }
}