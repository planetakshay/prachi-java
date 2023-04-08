package practice2023;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {
    public static int convertToNumber(String roman) {
        Map<Character, Integer> symbolsToPlace = new HashMap<>();
        symbolsToPlace.put('I', 1);
        symbolsToPlace.put('V', 5);
        symbolsToPlace.put('X', 10);
        symbolsToPlace.put('L', 50);
        symbolsToPlace.put('C', 100);
        symbolsToPlace.put('D', 500);
        symbolsToPlace.put('M', 1000);
        int number = 0;
        for (int i = 0; i < roman.length(); i++) {
            Character curr = roman.charAt(i);
            if (i > 0 && symbolsToPlace.get(roman.charAt(i)) > symbolsToPlace.get(roman.charAt(i - 1))) {
                number += symbolsToPlace.get(curr) - (2 * symbolsToPlace.get(roman.charAt(i - 1)));
            } else {
                number += symbolsToPlace.get(curr);
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println("Roman to Number: " + convertToNumber("MMMXX"));
    }
}
