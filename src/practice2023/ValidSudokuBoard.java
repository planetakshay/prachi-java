package practice2023;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ValidSudokuBoard {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("Is valid Sudoku: " + validSudoku(grid));

        grid = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("Is valid Sudoku: " + validSudoku(grid));
    }

    public static boolean validSudoku(char[][] board) {
        // validate board is 9x9 if required before proceeding down.
        Set<String> uniqueChars = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // check if current cell has a digit which is already seen
                // in another row before.
                char cell = board[i][j];
                if (cell != '.') {
                    if (!uniqueChars.add(cell + " row=" + i) ||
                            !uniqueChars.add(cell + " column=" + j) ||
                            !uniqueChars.add(cell + "subgrid=" + i / 3 + " to " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
