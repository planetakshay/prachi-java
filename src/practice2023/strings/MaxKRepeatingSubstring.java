package practice2023.strings;

/**
 * https://leetcode.com/problems/maximum-repeating-substring/description/
 */
public class MaxKRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        if(sequence == null || sequence.isBlank() || word == null || word.isBlank()) {
            return 0;
        }
        int count = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        while(sequence.contains(builder.toString())) {
            count++;
            builder.append(word);
        }
        return count;
    }
}
