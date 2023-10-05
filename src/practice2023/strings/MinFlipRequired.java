package practice2023.strings;

/**
 * https://leetcode.com/problems/minimum-suffix-flips/description/
 */
public class MinFlipRequired {
    public static void main(String[] args) {
        String target = "10111";
        System.out.println("Minimum flips required: " + minFlips(target));

        target = "1100000000";
        System.out.println("Minimum flips required: " + minFlips(target));

        target = "101";
        System.out.println("Minimum flips required: " + minFlips(target));

        target = "00000";
        System.out.println("Minimum flips required: " + minFlips(target));
    }
    public static int minFlips(String target) {
        char c = '0';
        int flipsRequired = 0;

        for(char ch : target.toCharArray()) {
            if(ch != c) {
                flipsRequired++;
                c = (c == '0') ? '1' : '0';
            }
        }

        return flipsRequired;
    }
}
