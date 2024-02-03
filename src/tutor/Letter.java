package tutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Character frequency displayed as a histogram.
 */
public class Letter {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/tutor/older1.txt"));
        int[] frequency = new int[27];

        for (char c = 'a'; c <= 'z'; c++) {
            frequency[c - 'a'] = 0;
        }
        while (input.hasNext()) {
            String thisLine = input.nextLine();
            thisLine = thisLine.toLowerCase();

            for (int i = 0; i < thisLine.length(); i++) {
                char ch = thisLine.charAt(i);
                int index = ch - 'a';
                if (index >= 0 && index <= 26) {
                    frequency[index]++;
                }
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int total = frequency[c - 'a'];
            if(total > 0) {
                System.out.print(c + ": ");
                for (int j = 1; j <= total; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}