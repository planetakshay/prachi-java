package practice2023.strings;

/**
 * https://leetcode.com/problems/shortest-word-distance/description/
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        int minDistance = len;
        int i = -1, j = -1;
        for (int ind = 0; ind < len; ind++) {
            if (word1.equals(wordsDict[ind])) {
                i = ind;
            } else if (word2.equals(wordsDict[ind])) {
                j = ind;
            }
            if (i != -1 && j != -1) {
                int distance = Math.abs(j - i);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }
}
