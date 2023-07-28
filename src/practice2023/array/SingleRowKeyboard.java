package practice2023.array;

/**
 * https://leetcode.com/problems/single-row-keyboard/
 */
public class SingleRowKeyboard {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        System.out.println("Distance: " + calculateTime(keyboard, word));

        keyboard = "pqrstuvwxyzabcdefghijklmno";
        word = "leetcode";
        System.out.println("Distance: " + calculateTime(keyboard, word));
    }

    public static int calculateTime(String keyboard, String word) {
        int distance = 0;
        int currIndex = 0;
        for (char ch : word.toCharArray()) {
            int index = keyboard.indexOf(ch);
            distance += Math.abs(index - currIndex);
            currIndex = index;
        }
        return distance;
    }
}