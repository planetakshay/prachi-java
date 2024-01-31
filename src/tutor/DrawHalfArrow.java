package tutor;

import java.util.Scanner;

/**
 * This program outputs a downwards facing arrow composed of a rectangle and a right triangle.
 * The arrow dimensions are defined by user specified arrow base height, arrow base width, and arrow head width.
 * <p>
 * (1) Modify the given program to use a loop to output an arrow base of height arrowBaseHeight.
 * (2) Modify the given program to use a loop to output an arrow base of width arrowBaseWidth.
 * Use a nested loop in which the inner loop draws the *’s, and the outer loop iterates a number of times equal to the height of the arrow base.
 * (3) Modify the given program to use a loop to output an arrow head of width arrowHeadWidth.
 * Use a nested loop in which the inner loop draws the *’s, and the outer loop iterates a number of times equal to the height of the arrow head.
 * <p>
 * (4) Modify the given program to only accept an arrow head width that is larger than the arrow base width.
 * Use a loop to continue prompting the user for an arrow head width until the value is larger than the arrow base width
 * <p>
 * while (arrowHeadWidth <= arrowBaseWidth) {
 * // Prompt user for a valid arrow head value
 * }
 * <p> Two students asked for the help so far.
 * Example output for arrowBaseHeight = 5, arrowBaseWidth = 2, and arrowHeadWidth = 4:
 * <p>
 * Enter arrow base height:
 * 5
 * Enter arrow base width:
 * 2
 * Enter arrow head width:
 * 4
 * <p>
 * <p>
 * **
 * **
 * **
 * **
 * **
 * ****
 * ***
 * **
 * *
 */
public class DrawHalfArrow {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter arrow base height:");
        int arrowBaseHeight = scnr.nextInt();

        System.out.println("Enter arrow base width:");
        int arrowBaseWidth = scnr.nextInt();

        System.out.println("Enter arrow head width:");
        int arrowHeadWidth = 0;
        while (arrowHeadWidth <= arrowBaseWidth) {
            arrowHeadWidth = scnr.nextInt();
        }
        System.out.println();

        // Print base.
        int height = arrowBaseHeight;
        while (height > 0) {
            int width = arrowBaseWidth;
            while (width > 0) {
                System.out.print("*");
                width--;
            }
            System.out.println("");
            height--;
        }
        // Print head
        int headWidth = arrowHeadWidth;
        for (int i = headWidth; i > 0; i--) {
            int temp = i;
            while (temp > 0) {
                System.out.print("*");
                temp--;
            }
            System.out.println("");
        }
    }
}