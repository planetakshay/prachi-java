package practice2023;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println("No of ways for 5: " + makeChangeDP(5));
        System.out.println("No of ways for 5: " + makeChangeRecursive(5));

        System.out.println("No of ways for 15: " + makeChangeDP(15));
        System.out.println("No of ways for 15: " + makeChangeRecursive(15));

        System.out.println("No of ways for 50: " + makeChangeDP(50));
        System.out.println("No of ways for 50: " + makeChangeRecursive(50));
    }

    public static int makeChangeDP(int amount) {
        int[] denom = new int[] {25, 10, 5, 1};
        int[][] map = new int[amount + 1][denom.length];
        return makeChangeDP(amount, denom, 0, map);
    }

    public static int makeChangeDP(int amount, int[] denom, int index, int[][]map) {

        if(map[amount][index] > 0) {
            return map[amount][index];
        }
        if(index >= denom.length - 1) {
            return 1;
        }
        int denomVal = denom[index];
        int ways = 0;

        for(int i = 0;i * denomVal <= amount ;i++) {
            int remaining = amount - (i * denomVal);
            ways += makeChangeDP(remaining, denom, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static int makeChangeRecursive(int amount) {
        int[] denom = new int[] {25, 10, 5, 1};
        return makeChangeRecursive(amount, denom, 0);
    }
    public static int makeChangeRecursive(int amount, int[] denom, int index) {
        if(index >= denom.length - 1) {
            return 1;
        }
        int currVal = denom[index];
        int ways = 0;
        for(int i = 0; i * currVal <= amount;i++) {
            int remaining = amount - (i * currVal);
            ways += makeChangeRecursive(remaining, denom, index + 1);
        }
        return ways;
    }
}
