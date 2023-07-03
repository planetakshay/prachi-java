package practice2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Things to verify is case sensitivity and handling spaces in the string.
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String input = "Prachi";
        System.out.println(input + " is a palindrome permutation: " + isPalindromePermutation(input));

        input = "aaaaaccbbccaaaaa";
        System.out.println(input + " is a palindrome permutation: " + isPalindromePermutation(input));
    }
    public static boolean isPalindromePermutation(String s) {
        if(s == null || s.isEmpty()) {
            return false;
        }
        Map<Character, Integer> frequency = new HashMap<>();
        char[] charArray = s.toCharArray();
        computeFrequency(charArray, frequency);

        for(char ch : charArray) {
            int count = frequency.getOrDefault(ch, 0);
            if(count % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static void computeFrequency(char[] charArray, Map<Character, Integer> freqMap) {
        for(char ch : charArray) {
            int count = freqMap.getOrDefault(ch, 0);
            freqMap.put(ch, count + 1);
        }
    }
}
