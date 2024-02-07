package practice2023.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * <p>
 * Top 150 Interview Questions.
 */
public class SurroundedRegions {
    int rows = 0;
    int columns = 0;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rows = board.length;
        columns = board[0].length;
        List<List<Integer>> borders = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            borders.add(Arrays.asList(i, 0));
            borders.add(Arrays.asList(i, columns - 1));
        }
        for (int i = 0; i < columns; i++) {
            borders.add(Arrays.asList(0, i));
            borders.add(Arrays.asList(rows - 1, i));
        }
        for (List<Integer> list : borders) {
            dfs(board, list.get(0), list.get(1));
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        if (row > 0) {
            dfs(board, row - 1, col);
        }
        if (row < rows - 1) {
            dfs(board, row + 1, col);
        }
        if (col > 0) {
            dfs(board, row, col - 1);
        }
        if (col < columns - 1) {
            dfs(board, row, col + 1);
        }
    }
}