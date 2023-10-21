package practice2023.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Interview quickstart exercise.
 */
public class RearrangeEvenAndOdd {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 9, 5, 2, 9, 5, 7, 10);
        System.out.println(segregateEvensAndOdds(numbers));

        numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println(segregateEvensAndOdds(numbers));
    }
    static List<Integer> segregateEvensAndOdds(List<Integer> numbers) {
        // Write your code here.
        int i = 0;
        int j = numbers.size() - 1;
        while(i < j) {
            int curr = numbers.get(i);
            if(curr % 2 == 1) {
                while(j > i && numbers.get(j) % 2 == 1) {
                    j--;
                }
                int temp = numbers.get(j);
                numbers.set(i, temp);
                numbers.set(j, curr);
            }
            i++;
        }
        return numbers;
    }
}
