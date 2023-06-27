package practice2023;

public class PowerOfTwo {
    public static void main(String[] args) {
        int num = 4;
        System.out.println("Num " + num + " is " + powerOfTwoArithmetic(num));
        System.out.println("Num " + num + " is " + bitManipulation(num));

        num = 5;
        System.out.println("Num " + num + " is " + powerOfTwoArithmetic(num));
        System.out.println("Num " + num + " is " + bitManipulation(num));

        num = 0;
        System.out.println("Num " + num + " is " + powerOfTwoArithmetic(num));
        System.out.println("Num " + num + " is " + bitManipulation(num));

        num = -8;
        System.out.println("Num " + num + " is " + powerOfTwoArithmetic(num));
        System.out.println("Num " + num + " is " + bitManipulation(num));

        num = -16;
        System.out.println("Num " + num + " is " + powerOfTwoArithmetic(num));
        System.out.println("Num " + num + " is " + bitManipulation(num));

        System.out.println("zero & -1 = " + bitManipulationZero());
    }

    public static boolean powerOfTwoArithmetic(int num) {
        if(num == 0) {
            return false;
        }
        while(num % 2 == 0) {
            num = num / 2;
            if(num == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean bitManipulation(int num) {
        // for power of Two numbers, & operation between number and a previous number
        // (number-1) will be 0. For numbers other than power of two
        // num & num-1 will be 1.

        if(num != 0 && (num & (num - 1)) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int bitManipulationZero() {
        int num = 0;
        return num & (num - 1);
    }
}
