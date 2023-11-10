package practice2023.tree;

/**
 * https://leetcode.com/problems/flood-fill/
 *
 * IK problem sets graphs.
 *
 * Interview Kickstart
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        changeColor(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void changeColor(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        changeColor(image, sr - 1, sc, color, oldColor);
        changeColor(image, sr + 1, sc, color, oldColor);
        changeColor(image, sr, sc - 1, color, oldColor);
        changeColor(image, sr, sc + 1, color, oldColor);
    }
}