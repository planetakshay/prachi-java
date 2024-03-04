package practice2023.strings;

/**
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompressionInPlace {

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println("New length: " + compressAdditionalSpace(chars));
        System.out.println("New length: " + compressInplace(chars));
    }

    public static int compressInplace(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int len = chars.length;
        int i = 0, index = 0;
        while (i < len) {
            int j = i;
            while (j < len && chars[j] == chars[i]) {
                j++;
            }
            chars[index++] = chars[i];
            if (j - i > 1) {
                String count = String.valueOf(j - i);
                // Since this is an array each digit in count will take up
                // one cell in the array.
                for (char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }

    public static int compressAdditionalSpace(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int len = chars.length;
        int counter = 1;
        StringBuilder builder = new StringBuilder();
        builder.append(chars[0]);
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[i - 1]) {
                counter++;
            } else {
                if (counter > 1) {
                    // builder.append(chars[i - 1]);
                    builder.append(counter);
                    counter = 1;
                }
                builder.append(chars[i]);
            }
        }
        if (counter > 1) {
            builder.append(counter);
        }
        String s = builder.toString();
        chars = s.toCharArray();
        return chars.length;
    }
}