package practice2023;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 * <p>
 * This is a specific case solution for 3x3.
 * <p>
 * We need to solve this for NxN.
 */
public class TicTacToe {

    public static void main(String[] args) {
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        String state = initTicTacToe(moves);
        System.out.println("state: " + state);

        moves = new int[][]{{0, 0}, {1, 1}};
        state = initTicTacToe(moves);
        System.out.println("state: " + state);
    }

    // From the given moves init the ticTacToe board.
    public static String initTicTacToe(int[][] moves) {
        int rows = 3, columns = 3;
        int movesSoFar = moves.length;
        char[][] ticTacToe = new char[rows][columns];

        for (int i = 0; i < movesSoFar; i++) {
            // Since A always makes the first move,
            // A's moves will be 0, 2, 4 and so on. even indices
            if (i % 2 == 0) {
                ticTacToe[moves[i][0]][moves[i][1]] = 'X';
            } else {
                // B's moves will be 1, 3, 5 and so on. odd indices
                ticTacToe[moves[i][0]][moves[i][1]] = '0';
            }
        }

        return checkState(ticTacToe);
    }

    public static String checkState(char[][] ticTacToe) {
        // Check rows
        int rows = ticTacToe.length;
        int cols = ticTacToe[0].length;
        for (int i = 0; i < rows; i++) {
            int asMoves = 0;
            int bsMoves = 0;
            for (int j = 0; j < cols; j++) {
                if (ticTacToe[i][j] == 'X') {
                    asMoves++;
                } else if (ticTacToe[i][j] == '0') {
                    bsMoves++;
                }
            }
            if (asMoves == 3) {
                return "A";
            } else if (bsMoves == 3) {
                return "B";
            }
        }

        for (int i = 0; i < rows; i++) {
            int asMoves = 0;
            int bsMoves = 0;
            for (int j = 0; j < cols; j++) {
                if (ticTacToe[j][i] == 'X') {
                    asMoves++;
                } else if (ticTacToe[j][i] == '0') {
                    bsMoves++;
                }
            }
            if (asMoves == 3) {
                return "A";
            } else if (bsMoves == 3) {
                return "B";
            }
        }

        if (ticTacToe[0][0] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][2] == 'X') {
            return "A";
        }
        if (ticTacToe[0][0] == '0' && ticTacToe[1][1] == '0' && ticTacToe[2][2] == '0') {
            return "B";
        }
        if (ticTacToe[0][2] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][0] == 'X') {
            return "A";
        }
        if (ticTacToe[0][2] == '0' && ticTacToe[1][1] == '0' && ticTacToe[2][0] == '0') {
            return "B";
        }
        boolean pending = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ticTacToe[i][j] != 'X' && ticTacToe[i][j] != '0') {
                    pending = true;
                    break;
                }
            }
        }
        if (pending) return "Pending";
        return "Draw";
    }
}
