package practice2023;

public class WorstTimeToBuy {
    public static void main(String[] args) {
        int[] prices = new int[]{10, 20, 25, 26, 2, 5, 9, 11, 12, 14};
        System.out.println("Max possible loss: " + worstDayToSell(prices));
    }

    public static int worstDayToSell(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lowInd = 0, highInd = 1, maxLoss = 0;
        while (highInd < prices.length) {
            if (prices[highInd] < prices[lowInd]) {
                int loss = prices[highInd] - prices[lowInd];
                if (loss < maxLoss) {
                    maxLoss = loss;
                }
            } else {
                lowInd = highInd;
            }
            highInd++;
        }
        System.out.println("Worst day to sell: " + lowInd);
        return maxLoss;
    }
}
