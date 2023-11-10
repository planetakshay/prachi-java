package practice2023.strings;

/**
 * https://leetcode.com/problems/shortest-word-distance-iii/description/
 */
public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        int shortestDist = Integer.MAX_VALUE;
        int prev = -1;
        for (int i = 0; i < len; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (prev != -1 && (!wordsDict[prev].equals(wordsDict[i]) || word1.equals(word2))) {
                    shortestDist = Math.min(i - prev, shortestDist);
                }
                prev = i;
            }
        }
        return shortestDist;
    }
}
