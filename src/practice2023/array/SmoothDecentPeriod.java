package practice2023.array;

public class SmoothDecentPeriod {
    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 1, 4};
        System.out.println("Smooth descending periods: " + getDescentPeriods(prices));
    }

    public static long getDescentPeriods(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int total = 1;
        int countSub = 1;
        for(int i = 0; i < len - 1; i++) {
            if(prices[i] - prices[i+1] == 1) {
                countSub++;
            } else {
                countSub = 1;
            }
            total += countSub;
        }
        return total;
    }
}