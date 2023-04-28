package practice2023;

import java.util.Scanner;

// https://leetcode.com/problems/bulb-switcher/submissions/940849135/
public class BulbSwitch {
    public static void main (String[] args) {
        System.out.println("Number of bulbs: ");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        //To-Do Validate num input to be only integer numbers for this problem.
        System.out.println("Total numbers of the turned on bulbs: " + bulbSwitch(num));
    }

    public static int bulbSwitch(int n) {
        int bulbsOn = 0;
        // After the toggling the only bulbs at the perfect square positions
        // will remain turned on.
        // All the other bulbs will get switched off at some point of time.
        for(int i=1;i*i<=n;i++) {
            bulbsOn++;
        }
        return bulbsOn;
    }
}
