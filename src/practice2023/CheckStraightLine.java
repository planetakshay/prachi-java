package practice2023;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 *
 * formula for straight line
 *
 * given coordinates of two points [x1,y1] and [x2,y2]
 * calculate gradient. If all points in the input have same gradient
 * then the points are on the straight line.
 *
 * Gradient formula = y2-y1 / x2 - x1 = change in y / change in x
 * Instead of the division to avoid getting in divide by zero issues
 * we will just use (change in y) * (x2 - x1) = (change in x) * (y2 - y1)
 */

public class CheckStraightLine {

    public static void main(String[] args) {
        int[][] coordinates = new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println("Is a straight line: " + checkStraightLine(coordinates));

        coordinates = new int[][] {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println("Is a straight line: " + checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        boolean straightLine = false;

        if(coordinates == null || coordinates.length == 0) {
            return straightLine;
        }

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        int diffX = x2 - x1;
        int diffY = y2 - y1;

        for(int[] coord : coordinates) {
            int x = coord[0];
            int y = coord[1];
            if( diffX * (y - y1) != diffY * (x - x1)) {
                return false;
            }
        }
        return true;
    }
}
