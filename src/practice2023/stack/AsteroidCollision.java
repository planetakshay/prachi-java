package practice2023.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = new int[]{5, 10, -5};
        System.out.println("Serviving Asteroids: " + Arrays.toString(survivingAsteroids(asteroids)));

        asteroids = new int[]{8, -8};
        System.out.println("Serviving Asteroids: " + Arrays.toString(survivingAsteroids(asteroids)));

        asteroids = new int[]{10, 2, -5};
        System.out.println("Serviving Asteroids: " + Arrays.toString(survivingAsteroids(asteroids)));
    }

    public static int[] survivingAsteroids(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        Stack<Integer> colliding = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                colliding.push(asteroid);
            } else {
                while (!colliding.isEmpty() && colliding.peek() > 0 && colliding.peek() < -asteroid) {
                    colliding.pop();
                }
                if (colliding.isEmpty() || colliding.peek() < 0) {
                    colliding.push(asteroid);
                } else if (colliding.peek() == -asteroid) {
                    colliding.pop();
                }
            }
        }
        return colliding.stream().mapToInt(Integer::intValue).toArray();
    }
}
