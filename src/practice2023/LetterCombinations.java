package practice2023;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinations {
    public static void main(String[] args) {
        List<String> combinations = letterCombinations("23");
        System.out.println("[" + combinations.stream().collect(Collectors.joining(", ")) + "]");
    }

    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() < 1) {
            return combinations;
        }

        Map<Character, List<String>> digitAlphaMap = new HashMap<>();
        digitAlphaMap.put('2', Arrays.asList("a", "b", "c"));
        digitAlphaMap.put('3', Arrays.asList("d", "e", "f"));
        digitAlphaMap.put('4', Arrays.asList("g", "h", "i"));
        digitAlphaMap.put('5', Arrays.asList("j", "k", "l"));
        digitAlphaMap.put('6', Arrays.asList("m", "n", "o"));
        digitAlphaMap.put('7', Arrays.asList("p", "q", "r", "s"));
        digitAlphaMap.put('8', Arrays.asList("t", "u", "v"));
        digitAlphaMap.put('9', Arrays.asList("w", "x", "y", "z"));

        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            lists.add(digitAlphaMap.get(digits.charAt(i)));
        }
        CartesianProductLimited<String> cartesianProductLimited = new CartesianProductLimited<>();
        List<List<String>> allCombo = cartesianProductLimited.product(lists);
        for(List<String> l : allCombo) {
            String curr = l.stream().collect(Collectors.joining());
            combinations.add(curr);
        }
        return combinations;
    }
}

class CartesianProductLimited<V> {

    public List<List<V>> product(List<List<V>> lists) {
        List<List<V>> product = new ArrayList<>();

        // We first create a list for each value of the first list
        product(product, new ArrayList<>(), lists);

        return product;
    }

    private void product(List<List<V>> result, List<V> existingTupleToComplete, List<List<V>> valuesToUse) {
        for (V value : valuesToUse.get(0)) {
            List<V> newExisting = new ArrayList<>(existingTupleToComplete);
            newExisting.add(value);

            // If only one column is left
            if (valuesToUse.size() == 1) {
                // We create a new list with the exiting tuple for each value with the value
                // added
                result.add(newExisting);
            } else {
                // If there are still several columns, we go into recursion for each value
                List<List<V>> newValues = new ArrayList<>();
                // We build the next level of values
                for (int i = 1; i < valuesToUse.size(); i++) {
                    newValues.add(valuesToUse.get(i));
                }
                product(result, newExisting, newValues);
            }
        }
    }
}