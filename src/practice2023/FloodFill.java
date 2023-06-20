package practice2023;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        changeColor(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void changeColor(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        changeColor(image, sr - 1, sc, color, oldColor);
        changeColor(image, sr + 1, sc, color, oldColor);
        changeColor(image, sr, sc - 1, color, oldColor);
        changeColor(image, sr, sc + 1, color, oldColor);
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(image,1,1,2)));
    }
}
