package practice2023.matrix;

import practice2023.tree.trie.TrieStructure;
import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 * <p>
 * HP Aruba Networks phone interview.
 * <p>
 * Find all possible valid words  in a MxN board.
 * 1. The words are formed by a sequence of adjacent characters.
 * 2. The cell can be used only once in a valid word.
 * <p>
 * <p>
 * D A T H
 * C G O A
 * S T A D
 * B E L S
 * <p>
 * e.g. SEAT,SEA, DATA are valid set of words
 * SEATS (not valid) because 'S' already used.
 *
 * The problem is also referred to as Word Search in
 * an m x n matrix.
 */
public class Boggle {

    private int rows;
    private int cols;

    private Set<String> words;

    private boolean[][] visited;

    private int[][] directions;

    private Set<String> dictionary;

    private TrieStructure trie;

    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        List<String> words = Arrays.asList("bed", "bag", "dog", "fish",
                "hike", "ace", "cat", "man", "kite", "geeks",
                "for", "quiz", "guq", "ee", "oath", "pea", "eat", "rain");
        boggle.initDictionary(words);
        boggle.initTrie(words);
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        System.out.println("Valid words in Boggle: " + boggle.constructValidWords(board));
    }

    public void initTrie(List<String> words) {
        trie = new TrieStructure();
        trie.insertAll(words);
    }

    public void initDictionary(List<String> words) {
        dictionary = new TreeSet<>() {{
            addAll(words);
        }};
    }

    private boolean isValid(String word) {
        boolean found = this.dictionary.contains(word);
        found = this.trie.search(word);
        return found;
    }

    public Set<String> constructValidWords(char[][] board) {
        words = new HashSet<>();
        if (board == null || board.length == 0) {
            return words;
        }

        this.rows = board.length;
        this.cols = board[0].length;
        visited = new boolean[rows][cols];
        directions = new int[][]{{1, 0}, {0, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                constructWords(board, i, j, new StringBuilder());
            }
        }
        return words;
    }

    private void constructWords(char[][] board, int row, int col, StringBuilder builder) {
        String word = builder.toString();
        if (isValid(word)) {
            words.add(word);
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            int nextR = row + dir[0];
            int nextC = col + dir[1];
            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || visited[nextR][nextC]) {
                continue;
            }
            constructWords(board, nextR, nextC, builder.append(board[nextR][nextC]));
            /* if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && !visited[nextR][nextC]) {
                constructWords(board, nextR, nextC, builder.append(board[nextR][nextC]));
            } */
        }
        // Clean up
        visited[row][col] = false;
        if (!builder.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}