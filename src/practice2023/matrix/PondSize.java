package practice2023.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Cracking the coding interview
 * Chapter 16: Moderate
 */
public class PondSize {

    public static void main(String[] args) {
        int[][] land = new int[][]{ {0, 2, 1, 0},
        {0, 1, 0, 1},
        {1, 1, 0, 1},
        {0, 1, 0, 1}};
        List<Integer> pondSizes = pondSize(land);
        System.out.println("Sizes: " + Arrays.toString(pondSizes.toArray()));
    }

    public static List<Integer> pondSize(int[][] land) {
        if (land == null || land[0].length == 0) {
            return null;
        }
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<Integer> sizes = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int size = computeSize(land, visited, i, j);
                if (size > 0) {
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    public static int computeSize(int[][] land, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= land.length || col < 0 || col >= land[0].length || land[row][col] != 0 || visited[row][col]) {
            return 0;
        }
        int size = 1;
        visited[row][col] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                size += computeSize(land, visited, row + i, col + j);
            }
        }
        return size;
    }
}
