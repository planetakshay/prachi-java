package practice2023;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutations {

    public static void main(String[] args) {
        List<String> permutations = getAllPermutations("Prachi");
        System.out.println("No of permutations: " + permutations.size());
        permutations.stream().forEach(permutation -> String.join(permutation, ", "));
        String output =  permutations.stream().collect(Collectors.joining(", "));
        System.out.println("[" + output +"]");
    }

    public static List<String> getAllPermutations(String input) {
        List<String> permutations = new LinkedList<>();
        if(input == null || input.length() < 1) {
            return permutations;
        }
        permutations(input,"", permutations);
        return permutations;
    }

    public static void permutations(String input, String ans, List<String> perms) {
        if(input.length() == 0) {
            perms.add(ans);
        }
        for(int i = 0; i< input.length();i++) {
            char ch = input.charAt(i);
            String restOfTheString = input.substring(0,i) + input.substring(i+1);
            permutations(restOfTheString, ans+ch, perms);
        }
    }
}
