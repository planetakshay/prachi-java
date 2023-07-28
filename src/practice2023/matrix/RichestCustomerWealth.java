package practice2023.matrix;

import java.util.LinkedList;
import java.util.List;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts = new int[][] {{1,2,3}, {3,2,1}};
        System.out.print("Richest Men: " + richestMen(accounts));
        System.out.print("\tMax wealth: " + maximumWealth(accounts));

        accounts = new int[][] {{1,5},{7,3},{3,5}};
        System.out.print("\nRichest Men: " + richestMen(accounts));
        System.out.print("\tMax wealth: " + maximumWealth(accounts));

        accounts = new int[][] {{2,8,7},{7,1,3},{1,9,5}};
        System.out.print("\nRichest Men: " + richestMen(accounts));
        System.out.print("\tMax wealth: " + maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length;i++) {
            int sum = 0;
            for(int j = 0; j<accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(sum, maxWealth);
        }
        return maxWealth;
    }

    public static List<Integer> richestMen(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length;i++) {
            int sum = 0;
            for(int j = 0; j<accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(sum, maxWealth);
        }
        List<Integer> richestMen = new LinkedList<>();
        for(int i = 0; i < accounts.length;i++) {
            int sum = 0;
            for(int j = 0; j<accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            if(sum >= maxWealth) {
                richestMen.add(i);
            }
        }
        return richestMen;
    }
}
