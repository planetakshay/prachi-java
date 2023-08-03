package practice2023.strings;

import java.util.*;

public class IndexPairsOfString {

    public static void main(String[] args) {
        String[] words = new String[] {"story","fleet","leetcode"};
        String text = "thestoryofleetcodeandme";
        System.out.println(Arrays.deepToString(indexPairs(text, words)));

        words = new String[] {"aba","ab"};
        text = "ababa";
        System.out.println(Arrays.deepToString(indexPairs(text, words)));
    }

    public static int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> result = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            // Start with j = i to handle repeated occurences of the word in the
            // same string.
            for (int j = i; j < text.length(); j++) {
                p = p.next.get(text.charAt(j));
                if (p == null) {
                    break;
                }
                if (p.flag) {
                    result.add(new int[] { i, j });
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
class TrieNode {
    public boolean flag;
    public Map<Character, TrieNode> next = new HashMap<>();
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.flag = true;
    }
}
