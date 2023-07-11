package practice2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/problems/bulb-switcher/submissions/940849135/
public class BulbSwitch {
    public static void main (String[] args) {
        /* System.out.println("Number of bulbs: ");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        //To-Do Validate num input to be only integer numbers for this problem.
        System.out.println("Total numbers of the turned on bulbs: " + bulbSwitch(num));

         */

        List<Long> inte = new ArrayList<>();
        inte.add(10l);
        inte.add(15l);
        inte.add(100l);
        List<Integer> answer = getValidKeyCount(inte);
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

    /**
     * Find valid keys from 1 to key[i] where
     * @param keys
     * @return
     */
    public static List<Integer> getValidKeyCount(List<Long> keys) {
        List<Integer> validCount = new LinkedList<>();
        if(keys == null || keys.size() == 0) {
            return validCount;
        }
        int len = keys.size();
        for(int i=0;i < len;i++) {
            Long num = keys.get(i);
            int valid = 0;
            for(int j=1;j<=num;j++) {
                int factors = 0;
                for(int k = 1;k <= j; k++) {
                    if(j % k == 0) {
                        factors++;
                    }
                }
                if(factors == 3) {
                    valid++;
                }
            }
            validCount.add(valid);
        }
        return validCount;
    }
}