package practice2023;

public class BestTimeToSell {

    public static int profitSingleTrans(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lowInd = 0, highInd = 1, maxProfit = 0;

        while (highInd < prices.length) {
            if (prices[highInd] > prices[lowInd]) {
                int profit = prices[highInd] - prices[lowInd];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                lowInd = highInd;
            }
            highInd++;
        }
        return maxProfit;
    }

    public static int profitMultiTrans(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;

        for (int i=1;i < prices.length;i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String args[]) {
        System.out.println("Maximum profit from single transaction: " + profitSingleTrans(new int[] {7,1,5,3,6,4}));
        System.out.println("Maximum profit from single transaction: " + profitSingleTrans(new int[] {7,6,4,3,1}));

        System.out.println("Maximum profit from multi transaction: " + profitMultiTrans(new int[] {7,1,5,3,6,4}));
        System.out.println("Maximum profit from multi transaction: " + profitMultiTrans(new int[] {7,6,4,3,1}));
    }
}
