package practice2023.matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        rotateRecursive(matrix, 0);
    }

    private void rotateRecursive(int[][] matrix, int row) {
        int n = matrix.length - 1;
        if (row == n) {
            return;
        }
        int i = row;
        for (int j = i; j < n - i; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - j][i];
            matrix[n - j][i] = matrix[n - i][n - j];
            matrix[n - i][n - j] = matrix[j][n - i];
            matrix[j][n - i] = temp;
        }
        rotateRecursive(matrix, row + 1);
    }

    private void rotateNonRecursive(int[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < rows / 2; i++) {
            for (int j = i; j < rows - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows - 1 - j][i];
                matrix[rows - 1 - j][i] = matrix[rows - 1 - i][rows - 1 - j];
                matrix[rows - 1 - i][rows - 1 - j] = matrix[j][rows - 1 - i];
                matrix[j][rows - 1 - i] = temp;
            }
        }
    }
}