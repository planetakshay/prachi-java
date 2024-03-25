package practice2023.design;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class PrefixTree {
    private final TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
        root.val = ' ';
    }
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(ch);
            }
            node = node.children[ch - 'a'];
        }
        node.word = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.word;
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}

class TrieNode {
    char val;
    boolean word;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {

    }

    public TrieNode(char ch) {
        TrieNode node = new TrieNode();
        this.val = ch;

    }
}