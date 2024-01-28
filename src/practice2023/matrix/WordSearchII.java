package practice2023.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchII {
    char[][] matrix = null;
    List<String> results = new ArrayList<>();

    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char ch : word.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    Trie newNode = new Trie();
                    node.children.put(ch, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.matrix = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    helper(i, j, root);
                }
            }
        }
        return results;
    }

    private void helper(int row, int col, Trie parent) {
        char ch = matrix[row][col];
        Trie curr = parent.children.get(ch);

        if (curr.word != null) {
            this.results.add(curr.word);
            curr.word = null;
        }

        this.matrix[row][col] = '#';

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (newRow < 0 || newRow >= this.matrix.length || newCol < 0 || newCol >= this.matrix[row].length) {
                continue;
            }
            if (curr.children.containsKey(this.matrix[newRow][newCol])) {
                helper(newRow, newCol, curr);
            }

            this.matrix[row][col] = ch;

            if (curr.children.isEmpty()) {
                parent.children.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        WordSearchII searchII = new WordSearchII();
        String[] words = new String[]{"aaaaa"};
        char[][] board = new char[][]{{'a', 'a'},{'a', 'a'}};
        System.out.println(searchII.findWords(board, words));
    }
}

class Trie {
    Map<Character, Trie> children = new HashMap<>();
    String word = null;

    public Trie() {

    }
}