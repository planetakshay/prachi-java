package practice2023;

/**
 * One ball is heavier/smaller out of N balls.
 * Find the odd one out in minimum number of comparisons.
 * Return number of comparisons required to find odd ball out.
 */
public class HeavierBall {

    public static void main(String[] args) {
        System.out.println("No of comparisons: " + findOddOne(10));
    }
    public static int findOddOne(int numOfBalls) {
        if(numOfBalls < 2) {
            return 0;
        }
        float attempts = numOfBalls;
        return (findOddOne((int) Math.ceil(numOfBalls / 3.0)) + 1);
    }
}