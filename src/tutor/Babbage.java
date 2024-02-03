package tutor;

import java.util.Scanner;

/**
 * calculate weekly and monthly pay.
 */
public class Babbage {
    public static void main(String[] args) {
        calculatePay();
    }

    public static void calculatePay() {
        Scanner input = new Scanner(System.in);
        double hourlyRate = 0.0;
        double hours = 0.0;
        double tax = 0.0;
        char runAgain = 0;

        do {
            System.out.println("Enter salary per hour:");
            hourlyRate = input.nextDouble();
            while (hourlyRate <= 0.0) {
                System.out.print("This is an invalid amount. Please enter a percentage between 0 and 100.");
                hourlyRate = input.nextDouble();
            }

            System.out.println("Enter the state tax as a percentage");
            tax = input.nextDouble();

            while (tax <= 0.0 || tax >= 100.0) {
                System.out.print("This is an invalid amount. Please enter a percentage between 0 and 100.");
                tax = input.nextDouble();
            }

            double monthlyPay = 0.0;
            for (int i = 1; i <= 4; i++) {
                System.out.println("Enter number of hours worked:");
                hours = input.nextDouble();
                while (hours <= 0.0) {
                    System.out.print("This is an invalid amount. ");
                    hours = input.nextDouble();
                }
                double homePay = hourlyRate * hours;
                homePay = homePay - (tax / 100) * homePay;
                System.out.println("You made $" + homePay + " in the current week.");
                monthlyPay += homePay;
            }
            System.out.println("You made $" + monthlyPay + " for the whole month");
            System.out.println("Do you want to enter again?");
            runAgain = input.next().charAt(0);
        } while (runAgain == 'Y' || runAgain == 'y');
    }
}