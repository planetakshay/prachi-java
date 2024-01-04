package practice2023.design;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    public static void main(String[] args) {

    }
    private static final String DELIMITER = "/:";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length())
                    .append(DELIMITER)
                    .append(str);
        }
        return builder.toString();
    }
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> original = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delim = s.indexOf(DELIMITER, i);
            int len = Integer.parseInt(s.substring(i, delim));
            int start = delim + DELIMITER.length();
            int end = start + len;
            String str = s.substring(start, end);
            original.add(str);
            i = end;
        }
        return original;
    }
}