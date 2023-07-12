package practice2023.strings;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaaabbccccdddefghijk";
        System.out.println("String compression: " + compress(s));

        s = "abcdefghijk";
        System.out.println("String compression: " + compress(s));
    }

    public static String compress(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int resultLen = countCompressions(s);
        if(resultLen >= s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i = 1;i < s.length();i++) {
            count++;
            if(s.charAt(i-1) != s.charAt(i)) {
                sb.append(s.charAt(i-1));
                if(count > 1) {
                    sb.append(count);
                }
                count = 0;
            }
        }
        String compressedString = sb.toString();
        return compressedString.length() < s.length() ? compressedString : s;
    }

    public static int countCompressions(String s) {
        int count=0;
        for(int i = 1;i < s.length();i++) {
            count++;
            if(s.charAt(i-1) != s.charAt(i)) {
                count = 0;
            }
        }
        return count;
    }
}