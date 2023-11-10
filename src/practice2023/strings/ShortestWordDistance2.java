package practice2023.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 */
public class ShortestWordDistance2 {
    Map<String, List<Integer>> locations;
    public ShortestWordDistance2(String[] wordsDict) {
        this.locations = new HashMap<>();
        int len = wordsDict.length;
        for (int i = 0; i < len; i++) {
            String word = wordsDict[i];
            List<Integer> loc = locations.getOrDefault(word, new ArrayList<>());
            loc.add(i);
            locations.put(word, loc);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> word1Loc = locations.get(word1);
        List<Integer> word2Loc = locations.get(word2);
        int i = 0, j = 0, minDist = Integer.MAX_VALUE;
        while (i < word1Loc.size() && j < word2Loc.size()) {
            minDist = Math.min(minDist, Math.abs(word1Loc.get(i) - word2Loc.get(j)));
            if (word1Loc.get(i) < word2Loc.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return minDist;
    }
}