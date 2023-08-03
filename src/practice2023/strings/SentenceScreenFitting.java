package practice2023.strings;

public class SentenceScreenFitting {

    public static void main(String[] args) {
        String[] sentence = new String[]{"hello", "world"};
        System.out.println("No of times the sentence can be printed: " + wordsTyping(sentence, 2, 8));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder str = new StringBuilder();
        for (String word : sentence) {
            str.append(word).append(' ');
        }
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start = start + cols;
            if (str.charAt(start % str.length()) == ' ') {
                start++;
            }
            while (start > 0 && str.charAt((start - 1) % str.length()) != ' ') {
                start--;
            }
        }
        return start / str.length();
    }
}
