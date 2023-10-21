package practice2023.recursion;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * <p>
 * IK sudoku solver is included as part of recursion class
 * assignment.
 */

import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    public static final Integer BOARD_SIZE = 9;
    public static final Integer SUB_GRID_SIZE = 3;
    List<List<Integer>> board;

    public SudokuSolver(List<List<Integer>> board) {
        this.board = board;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    void solveSudoku() {
        populateCells();
    }

    boolean populateCells() {
        int row = 0, col = 0;
        boolean unfilledCellFound = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board.get(i).get(j) == 0) {
                    row = i;
                    col = j;
                    unfilledCellFound = true;
                    break;
                }
            }
            if (unfilledCellFound) {
                break;
            }
        }
        // Board is filled with valid numbers. Sudoku is solved.
        if (!unfilledCellFound) {
            return true;
        }

        for (int num = 1; num <= BOARD_SIZE; num++) {
            if (isSafe(row, col, num)) {
                board.get(row).set(col, num);

                if (populateCells()) {
                    return true;
                } else {
                    board.get(row).set(col, 0);
                }
            }
        }
        return false;
    }

    boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board.get(row).get(i) == num) {
                return false;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board.get(i).get(col) == num) {
                return false;
            }
        }

        int boxRowStart = row - row % SUB_GRID_SIZE;
        int boxColStart = col - col % SUB_GRID_SIZE;

        for (int i = boxRowStart; i < boxRowStart + SUB_GRID_SIZE; i++) {
            for (int j = boxColStart; j < boxColStart + SUB_GRID_SIZE; j++) {
                if (board.get(i).get(j) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(char[][] board) {
        helper(board);
    }

    private static boolean helper(char[][] board) {
        int row = 0, col = 0;
        boolean unfilledCellFound = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    unfilledCellFound = true;
                    break;
                }
            }
            if (unfilledCellFound) {
                break;
            }
        }
        if (!unfilledCellFound) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = (char) ('0' + num);
                if (helper(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int num) {
        char val = (char) ('0' + num);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
