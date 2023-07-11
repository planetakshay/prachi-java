package practice2023;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = new int[]{0, 1, 2, 2};
        System.out.println("Maximum: " + fruitIntoBasket(fruits));

        fruits = new int[]{1, 2, 3, 2, 2};
        System.out.println("Maximum: " + fruitIntoBasket(fruits));

        fruits = new int[]{1, 2, 1};
        System.out.println("Maximum: " + fruitIntoBasket(fruits));

        fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println("Maximum: " + fruitIntoBasket(fruits));
    }

    public static int fruitIntoBasket(int[] fruits) {
        int max = 0;
        int curr = -1, prev = -1, currCount = 0;
        int currMax = 0;

        for (int fruit : fruits) {
            if (fruit == curr || fruit == prev) {
                currMax += 1;
            } else {
                currMax = currCount + 1;
            }

            if (fruit == curr) {
                currCount += 1;
            } else {
                currCount = 1;
            }

            if (fruit != curr) {
                prev = curr;
                curr = fruit;
            }
            max = Math.max(currMax, max);
        }
        return max;
    }
    /* public static int fruitIntoBasket(int[] fruits) {
        if(fruits == null || fruits.length == 0) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0, end = 0, max = 0;
        int k = 2;
        while(end < fruits.length) {
            int i = fruits[end];
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            while(freq.size() > k) {
                freq.put(fruits[start], freq.getOrDefault(fruits[start],0) - 1);
                if(freq.get(fruits[start]) == 0) {
                    freq.remove(fruits[start]);
                }
                start++;
            }
            if(freq.size() == k) {
                max = Math.max(freq.size(), (end - start) + 1);
            }
            end++;
        }
        return max;
    } */
}