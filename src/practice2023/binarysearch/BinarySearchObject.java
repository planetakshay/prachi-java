package practice2023.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Activision Blizzard Media onsite.
 */
public class BinarySearchObject {

    // Treat the following method as a library method
    // And it always correctly detects if the list has a
    // green ball or not in constant time.
    public static boolean hasGreenBall(List<Ball> balls, int start, int end) {
        if (start >= end || balls.isEmpty()) {
            return false;
        }
        List<Ball> greenBalls = balls.subList(start, end).stream().filter(ball -> ball.getColor() == Ball.Color.GREEN.getId()).toList();
        return greenBalls.size() == 1;
    }

    public Ball findGreenBall(List<Ball> balls) {
        // return binarySearch(balls, 0, balls.size() - 1);
        return binarySearchIterative(balls, 0, balls.size() - 1);
    }

    /**
     * ArrayList's sublist method provides a lightweight view of
     * original list, fromIndex inclusive and toIndex exclusive.
     * and hence the time and space complexity of subList method
     * is O(1)
     * <p>
     * USING SUBLIST FOR THIS PROBLEM IS ABSOLUTELY OK.
     *
     * @param balls balls to be searched through.
     * @return returns the green ball in the collection.
     */
    public Ball binarySearch(List<Ball> balls, int start, int end) {
        if(start > end) {
            return null;
        }
        if(start == end) {
            return balls.get(start).getId() == Ball.Color.GREEN.getId() ? balls.get(start) : null;
        }
        int mid = start + (end - start) / 2;
        if (BinarySearchObject.hasGreenBall(List.of(balls.get(mid)), 0, 1)) {
            return balls.get(mid);
        } else if (BinarySearchObject.hasGreenBall(balls, start, mid)) {
            return binarySearch(balls, start, mid);
        } else {
            return binarySearch(balls, mid + 1, end);
        }
    }
    public Ball binarySearchIterative(List<Ball> balls, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (BinarySearchObject.hasGreenBall(List.of(balls.get(mid)), 0, 1)) {
                return balls.get(mid);
            } else if (BinarySearchObject.hasGreenBall(balls, start, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start == end && balls.get(start).getId() == Ball.Color.GREEN.getId() ? balls.get(start) : null;
    }

    public static void main(String[] args) {
        BinarySearchObject binarySearchObject = new BinarySearchObject();
        List<Ball> balls = new ArrayList<>();
        for(int i=1; i <= 50; i++) {
            Ball ball = new Ball(i, Ball.Color.RED.getId());
            balls.add(ball);
        }
        // Randomly set one ball to green color.
        Random random = new Random();
        int index = random.nextInt(0, 50);
        balls.set(index, new Ball(index, Ball.Color.GREEN.getId()));

        Ball greenBall = binarySearchObject.findGreenBall(balls);
        System.out.println("Green Ball: " + greenBall);
    }
}