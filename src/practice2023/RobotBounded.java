package practice2023;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/description/
 */
public class RobotBounded {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0, y = 0;
        int g = 0;

        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                // Turning left is equivalent to turning right three times.
                // We will have to deal with negative directions if we
                // perform g = (g - 1) %4 instead perform g + 3 % 4 to
                // arrive at the same position when instruction is to move
                // to left.
                g = (g + 3) % 4;
            } else if (ch == 'R') {
                // If g == 3 (west direction) then moving to right will
                // bring robot to face north. i.e. g = 0. We need to
                // perform modulo 4 while moving to right
                // to check if robot is facing north.
                g = (g + 1) % 4; //
            } else {

                x += directions[g][0];
                y += directions[g][1];
            }
        }
        // original position or not facing north.
        return (x == 0 && y == 0) || (g != 0);
    }
}
