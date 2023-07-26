package practice2023;

import java.util.Arrays;
import java.util.Stack;

public class WarmerDays {

    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 76, 73};
        int[] warmerDays = findWarmerDays(temps);
        System.out.println("Days: " + Arrays.toString(warmerDays));

        temps = new int[]{73, 64, 63, 62, 65, 76, 73};
        warmerDays = findWarmerDays(temps);
        System.out.println("Days: " + Arrays.toString(warmerDays));

        temps = new int[]{73, 74, 75, 71, 69, 76, 73};
        warmerDays = findWarmerDays(temps);
        System.out.println("Days: " + Arrays.toString(warmerDays));
    }

    public static int[] findWarmerDays(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int len = temperatures.length;
        int[] warmerDays = new int[len];
        Stack<Integer> holder = new Stack<>();
        holder.push(0);
        for(int i = 1; i < len;i++) {
            while (!holder.isEmpty() && temperatures[i] > temperatures[holder.peek()]) {
                warmerDays[holder.peek()] = i - holder.pop();
            }
            holder.push(i);
        }
        return warmerDays;
    }
}
