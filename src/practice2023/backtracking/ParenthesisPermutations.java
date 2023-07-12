package practice2023.backtracking;

import java.util.*;

public class ParenthesisPermutations {

    public static void main(String[] args) {
        Set<String> permutations = validParenPermutations(1);
        permutations = validParenPermutations(2);
        permutations = validParenPermutations(3);
        permutations = validParenPermutations(10);
    }

    public static Set<String> validParenPermutations(int n) {
        Set<String> perms = new HashSet<>();
        generatePermutations(perms, "", 0, 0, n);
        System.out.println("Total = " + perms.size() + " permutations of parenthesis for n = " + n);
        System.out.println(Arrays.toString(perms.toArray()));
        return perms;
    }

    public static void generatePermutations(Set<String> permutations, String toAppend, int open, int close, int max) {
        if (toAppend.length() == max * 2) {
            permutations.add(toAppend);
        }
        if (open < max) {
            generatePermutations(permutations, toAppend + "(", open + 1, close, max);
        }
        if (close < open) {
            generatePermutations(permutations, toAppend + ")", open, close + 1, max);
        }
    }
}
