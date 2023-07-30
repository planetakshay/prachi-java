package practice2023.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullyJustifyText {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> lines = fullJustify(words, maxWidth);
        lines.stream().forEach(System.out::println);

        System.out.println("\n");

        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        lines = fullJustify(words, maxWidth);
        lines.stream().forEach(System.out::println);

        System.out.println("\n");

        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        lines = fullJustify(words, maxWidth);
        lines.stream().forEach(System.out::println);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int i=0;
        while(i < words.length) {
            List<String> line = getWords(i , words, maxWidth);
            i += line.size();
            ans.add(createLine(line, i , words, maxWidth));
        }
        return ans;
    }

    public static List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> currLine = new LinkedList<>();
        int currLength = 0;
        while(i < words.length && currLength + words[i].length() <= maxWidth) {
            currLine.add(words[i]);
            currLength += words[i].length() + 1;
            i++;
        }
        return currLine;
    }

    public static String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for(String word : line) {
            baseLength += word.length() + 1;
        }
        int extraSpaces = maxWidth - baseLength;
        if(line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }
        int wordCount = line.size() - 1;
        int spacePerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;
        for(int j=0; j<needsExtraSpace;j++) {
            line.set(j, line.get(j) + " ");
        }
        for(int j=0; j<wordCount; j++) {
            line.set(j,line.get(j) + " ".repeat(spacePerWord));
        }
        return String.join(" ", line);
    }
}