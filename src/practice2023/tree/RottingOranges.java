package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int totalOranges = 0;
        Queue<int[]> rottenCells = new LinkedList<>();
        // insert all rotten cells in the queue.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cell = grid[i][j];
                if (cell != 0) {
                    totalOranges++;
                    if (cell == 2) {
                        rottenCells.add(new int[]{i, j});
                    }
                }
            }
        }
        if (totalOranges == 0) {
            return 0;
        }

        int countMin = 0, count = 0;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while (!rottenCells.isEmpty()) {
            int size = rottenCells.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] cell = rottenCells.poll();
                for (int j = 0; j < dy.length; j++) {
                    int x = cell[0] + dx[j];
                    int y = cell[1] + dy[j];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    rottenCells.add(new int[]{x, y});
                }
            }
            if (rottenCells.size() != 0) {
                countMin++;
            }
        }
        return totalOranges == count ? countMin : -1;
    }
}
