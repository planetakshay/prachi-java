package practice;

public class FibonacciSeries {
	public static void main(String args[]) {

		fiboDynamicProgramming(10);

		System.out.println();

		nonRecursiveFibo(10);

		System.out.println();

		for (int i = 1; i < 10; i++) {

			System.out.println(fiboRecursive(i));
		}
	}

	public static void nonRecursiveFibo(int number) {

		if (number <= 0) {

			return;
		}
		int prev, next, sum;
		prev = next = 1;
		for (int n = 1; n <= number; n++) {
			System.out.print(prev + "\t");
			sum = prev + next;
			prev = next;
			next = sum;
		}
	}

	/**
	 * Intuit Phone Screen (Year 2013) Asked to use Dynamic Programming instead
	 * of recursive
	 * 
	 * @param number
	 */
	public static void fiboDynamicProgramming(int number) {

		if (number <= 0) {

			return;
		}

		int[] remember = new int[number + 1];

		remember[0] = 1;

		System.out.print(remember[0] + "\t");

		remember[1] = 1;

		System.out.print(remember[1] + "\t");

		for (int n = 2; n < number; n++) {

			remember[n] = remember[n - 1] + remember[n - 2];

			System.out.print(remember[n] + "\t");
		}
	}

	public static int fiboRecursive(int num) {

		if (num <= 0) {

			return -1;
		}

		if (num > 0 && num <= 2) {

			return 1;
		}

		return fiboRecursive(num - 1) + fiboRecursive(num - 2);
	}
}