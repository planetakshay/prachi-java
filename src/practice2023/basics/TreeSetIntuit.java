package practice2023.basics;

import java.util.*;

public class TreeSetIntuit {
    public static void main(String[] args) {
        int[][] dataset = new int[][]{{5, 9, 2, 8}, {4, 9, 3, 11}, {8, 15, 28, 30}};
        System.out.println("Total: " + totalQuotients(dataset));
        System.out.println("Total using TreeSet: " + totalQuotientsTreeSet(dataset));
    }
    public static int totalQuotients(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            List<Integer> sorted = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                sorted.add(matrix[i][j]);
            }
            Collections.sort(sorted, Collections.reverseOrder());
            for (int j = 0; j < sorted.size(); j++) {
                int ele = sorted.get(j);
                for (int k = 0; k < columns; k++) {
                    int curr = matrix[i][k];
                    if ((ele != curr) && (ele % curr == 0)) {
                        sum += (ele / curr);
                    }
                }
            }
        }
        return sum;
    }

    public static int totalQuotientsTreeSet(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            TreeSet<Integer> sorted = new TreeSet<>(Collections.reverseOrder());
            for (int j = 0; j < columns; j++) {
                sorted.add(matrix[i][j]);
            }
            Iterator ite = sorted.descendingIterator();
            while (ite.hasNext()) {
                Integer ele = (Integer) ite.next();
                for (int k = 0; k < columns; k++) {
                    int curr = matrix[i][k];
                    if ((ele != curr) && (ele % curr == 0)) {
                        sum += (ele / curr);
                    }
                }
            }
        }
        return sum;
    }
}