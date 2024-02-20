package practice2023.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generalized-abbreviation/description/
 */
public class GeneralizedAbbreviation {
    List<String> abbreviations;
    StringBuilder builder;
    int wordLen = 0;

    public static void main(String[] args) {
        GeneralizedAbbreviation generalizedAbbreviation = new GeneralizedAbbreviation();
        System.out.println(generalizedAbbreviation.generateAbbreviations("a"));
    }

    public List<String> generateAbbreviations(String word) {
        abbreviations = new ArrayList<>();
        builder = new StringBuilder();
        wordLen = word.length();
        helper(word, 0, 0);
        return abbreviations;
    }

    private void helper(String word, int offset, int abbrCharCount) {
        int len = builder.length();
        if (offset == wordLen) {
            // append abbreviated character count.
            if (abbrCharCount != 0) {
                builder.append(abbrCharCount);
            }
            abbreviations.add(builder.toString());
        } else {
            helper(word, offset + 1, abbrCharCount + 1);
            if (abbrCharCount != 0) {
                builder.append(abbrCharCount);
            }
            builder.append(word.charAt(offset));
            helper(word, offset + 1, 0);
        }
        builder.setLength(len);
    }
}