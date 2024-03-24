package practice2023.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
public class LuckyNumber {
    public List<Integer> luckyNumbers(int[][] matrix) {
        Set<Integer> rowMin = new HashSet<>();
        Set<Integer> colMax = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin.add(min);
        }

        for (int i = 0; i < cols; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            colMax.add(max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowMin.contains(matrix[i][j]) && colMax.contains(matrix[i][j])) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}