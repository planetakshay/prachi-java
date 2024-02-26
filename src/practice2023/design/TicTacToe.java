package practice2023.design;

public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int len;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        len = n;
    }

    public int move(int row, int col, int player) {
        int curr = player == 1 ? 1 : -1;
        rows[row] += curr;
        cols[col] += curr;

        if (row == col) {
            diagonal += curr;
        }
        if (col == (len - row - 1)) {
            antiDiagonal += curr;
        }
        if (Math.abs(rows[row]) == len ||
                Math.abs(cols[col]) == len ||
                Math.abs(diagonal) == len ||
                Math.abs(antiDiagonal) == len) {
            return player;
        }
        return 0;
    }
}