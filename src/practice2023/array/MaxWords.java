package practice2023.array;

/**
 *
 */
public class MaxWords {
    public static void main(String[] args) {
        String[] sentences = new String[]{"alice and bob love leetcode","i think so too","this is great thanks very much"};
        System.out.println("Maximum words: " + mostWordsFound(sentences));
    }
    public static int mostWordsFound(String[] sentences) {
        if(sentences == null || sentences.length==0) {
            return 0;
        }
        int maxWords = 0;
        for(String sentence : sentences) {
            int words = 1;
            int len = sentence.length();
            for(int i = 0; i < len; i++) {
                char ch = sentence.charAt(i);
                if(ch == ' ') {
                    words++;
                }
            }
            maxWords = Math.max(words, maxWords);
        }
        return maxWords;
    }
}
