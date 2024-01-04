package practice2023.binarysearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Interview Kickstart review material.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // We need to search through all cells in the matrix.
        // Start at 0th cell and end at the last cell.
        // i.e. rows * cols - 1;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}