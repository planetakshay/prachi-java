package practice2023.array;

import java.util.ArrayList;
import java.util.List;

public class StripOutCharacters {
    public static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        String[] input = {"aabbcc233", "234", "A1F", "234ssfs", "Adfa232123afa", "a1c2b4n5daf56dfa23", "Jee10"};
        // input = new String[] {"234", "A1F", "Jee10"};
        removeCharacters(input);
        System.out.println(output);
    }

    public static void removeCharacters(String[] input) {
        if (input == null) {
            return;
        }
        for (String in : input) {
            if (in != null && !in.trim().isEmpty()) {
                addNumber(in);
            }
        }
    }

    public static void addNumber(String in) {
        int len = in.length();
        char[] chars = in.toCharArray();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < len) {
            char curr = chars[i];
            if (Character.isDigit(curr)) {
                builder.append(curr);
            } else {
                String numStr = builder.toString();
                if (numStr != null && !numStr.trim().isBlank()) {
                    int num = Integer.parseInt(numStr);
                    output.add(num);
                    builder.setLength(0);
                }
            }
            i++;
        }
        // You may have some digits remaining in the builder.
        if (!builder.isEmpty()) {
            output.add(Integer.parseInt(builder.toString()));
        }
    }
}