package practice2023.array;

import java.util.Arrays;

public class DestroyingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {3,9,19,5,21};
        int mass = 10;
        System.out.println("Can all the asteroids be destroyed: " + asteroidsDestroyed(mass, asteroids));
        asteroids = new int[]{4,9,23,4};
        mass = 5;
        System.out.println("Can all the asteroids be destroyed: " + asteroidsDestroyed(mass, asteroids));

        asteroids = new int[]{};
        mass = 81583;
        System.out.println("Can all the asteroids be destroyed: " + asteroidsDestroyed(mass, asteroids));
    }
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) {
            return true;
        }
        Arrays.sort(asteroids);
        long sum = mass;
        for(int ast : asteroids) {
            if(ast > sum) {
                return false;
            }
            sum += ast;
        }
        return true;
    }
}
