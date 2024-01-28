package practice2023.tree.trie;

import java.util.List;

public class TrieStructure {
    private TrieNode root;

    public TrieStructure() {
        root = new TrieNode();
    }

    public void insertAll(List<String> words) {
        for(String word : words) {
            insert(word);
        }
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode(ch);
            }
            curr = curr.children[index];
        }
        curr.lastChar = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.lastChar;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if(node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

class TrieNode {
    char letter;
    boolean lastChar;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[27];
    }

    public TrieNode(char letter) {
        this.letter = letter;
        children = new TrieNode[27];
    }
}