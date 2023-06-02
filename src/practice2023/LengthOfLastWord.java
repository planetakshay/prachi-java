package practice2023;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("Length of the last word: " + lengthOfLastWord("Hello World"));
        System.out.println("Length of the last word: " + lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("Length of the last word: " + lengthOfLastWord("luffy is still joyboy"));
    }
    public static int lengthOfLastWord(String s) {
        if(s.isBlank()) {
            return 0;
        }
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }
}
