package practice;

public class Palindrome {
	
	public static void main(String args[]) {
		
		int digit = 0;
		int rev = 0;
		
		int num = 1234456;
		
		while (num > 0) {
			
			digit = num % 10;
			rev = rev * 10 + digit;
			num = num / 10;
		}
		
		System.out.println("Reverse: " + rev );
	}
}