package practice;

import java.util.Stack;

public class MathProblems {

	public static void main(String args[]) {

		MathProblems problems = new MathProblems();

		int sum = problems.multipleof3Or5(1000);

		System.out
				.printf("Sum of all numbers below 1000 divisible by 3 or 5 = %d\n",
						sum);

		int largestPrimeFactor = (int) problems
				.largetPrimeFactor(600851475143d);

		System.out.printf("Largest Prime Factor is %d", largestPrimeFactor);

		problems.swapTwoIntegers(5, 9);

		System.out.println("Reverse Number: " + problems.reverseInt(1234567));
		System.out.println("Reverse Number: " + problems.reverseInt(-8910));
		System.out.println("Reverse Number: " + problems.reverseInt(Integer.MAX_VALUE));
		System.out.println("Reverse Number: " + problems.reverseInt(Integer.MIN_VALUE));
		System.out.println("Column Number: "
				+ problems.getNumberForExcelColumn("AB"));

		System.out.println("Column Name: " + problems.GetExcelColumnName(703));

		problems.getMagicNumber();

		problems.firstNPrimeNumbers(50);

		System.out.println("\nNo of digits: "
				+ problems.countTotalDigits(1000000000));

		System.out.println("Binary version of number 23: "
				+ problems.getBinary(23));

		System.out.println("Exponential operation: "
				+ (int) problems.pow(125, 2));

		int array[] = new int[] { 1, 1, 1, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6,
				6, 6, 6, 4, 8 };

		System.out.println("Majority or a Leader Element: "
				+ problems.getMajority(array));

		int[] denoms = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };

		System.out.println(ways(denoms, denoms.length, 200));

		int[] arrayWith1And0 = new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };

		problems.arraysWithZerosAndOnes(arrayWith1And0);

		System.out.println("\nDigits: " + problems.getDigits(123456, 3));

		int[] missingNums = new int[100];

		for (int i = 0; i < missingNums.length - 1; i++) {

			missingNums[i] = i + 1;
		}

		System.out.println("Missing number from 1 to 100 is: "
				+ problems.missingNumber(missingNums));

		System.out.println("Missing number from 1 to 100 is: "
				+ problems.missingNumberXOR(missingNums));

		System.out.println("Last member who did not receive cake: "
				+ problems.remaining(5, 3));

		int[] maxDifference = new int[] { 1, 2, 3, 4, 5, 7, 8, 15, 18, 3, -20,
				-30 };

		System.out.println("Minimum difference: "
				+ problems.findPairWithMaxDifference(maxDifference));
	}

	public int multipleof3Or5(int upperLimit) {

		int sum = 0;

		for (int i = 1; i < upperLimit; i++) {

			if (i % 3 == 0 || i % 5 == 0) {

				sum += i;
			}
		}

		return sum;

	}

	public boolean test() {

		byte abc = 100;

		abc = (byte) (abc * 2);

		return false;
	}

	public int largetPrimeFactor(double number) {

		int i = 0;

		for (i = 2; i <= number; i++) {

			if (number % i == 0) {

				number /= i;

				i--;
			}
		}

		return i;
	}

	public void swapTwoIntegers(int a, int b) {

		a = b - a;

		b = b - a;

		a = a + b;

		System.out.println("A: " + a);

		System.out.println("B: " + b);
	}

	/**
	 * This could lead to interger overflow if N is too big. Alternatively xor
	 * approach can be used.
	 * 
	 * @param array
	 * @return
	 */
	public int missingNumber(int[] array) {

		int sigma = 0, arraySum = 0, length = array.length;

		for (int i = 0; i < length; i++) {

			arraySum += array[i];
		}
		for (int i = 1; i <= length; i++) {

			sigma += i;
		}

		return sigma - arraySum;
	}

	public int missingNumberXOR(int[] array) {

		int xorArray = array[0];
		int xor = 1;

		for (int i : array) {

			xorArray = xorArray ^ i;
		}

		for (int i = 1; i <= array.length; i++) {

			xor = xor ^ i;
		}

		return xorArray ^ xor;
	}

	public int reverseInt(int number) {
		boolean isNegative = false;
		if(number < 0) {
			isNegative = true;
			number *= -1;
		}
		int digit = 0;
		long reverse = 0;
		while (number > 0) {
			digit = number % 10;
			reverse = reverse * 10 + digit;
			number = number / 10;
		}
		if(isNegative) {
			reverse *= -1;
		}
		if(reverse > Integer.MAX_VALUE) {
			System.out.println("Integer overflow: " + reverse);
			reverse = 0;
		} else if(reverse < Integer.MIN_VALUE) {
			System.out.println("Integer underflow: " + reverse);
			reverse = 0;
		}
		return (int) reverse;
	}

	/**
	 * This question was asked in Kaboodle's on-site.
	 * 
	 * @param sxCol
	 * @return
	 */
	int getNumberForExcelColumn(String sxCol) {
		int result = 0;
		sxCol = sxCol.toUpperCase(); // This is important as we are going to be
										// using capital letters's value
										// corresponding to its real ascii
										// value. We will substract the capital
										// letters' ascii values from 64 during
										// each pass to get result, Value of A
										// is 1, B is 2, C is 3 and so on...
		if (sxCol.isEmpty())
			return result;

		for (int i = sxCol.length(); i > 0; i--) {
			char _c = sxCol.charAt(i - 1);
			//
			// Function => (26 ^ reversed_char_index) * char_value
			// A = 1 ------ Z = 26 ------ AA = 27 ------ AZ = 54
			// 64 because Ascii value of Capital letters is 65 and onwards so
			// for 'A' we will get value 1 for B 2 and so on
			result += Math.pow(26, sxCol.length() - i) * (_c - 64);
		}

		return result;
	}

	private String GetExcelColumnName(int columnNumber) {
		int dividend = columnNumber;
		String columnName = "";
		int modulo;

		while (dividend > 0) {
			modulo = (dividend - 1) % 26;
			columnName = (char) (65 + modulo) + columnName;
			dividend = ((dividend - modulo) / 26);
		}

		return columnName;
	}

	/**
	 * This question was asked by Proofpoint Inc. recruiter Problem is given all
	 * six digit numbers take first 3 digits of a number. Add those three digits
	 * into remaining three digits of the number. Now square the result of
	 * summation. If the final result is same as original number then return
	 * print the number.
	 */
	private void getMagicNumber() {

		// Brute force way.
		for (int i = 100000; i <= 999999; i++) {

			int first = i / 1000;

			int second = i % 1000;

			if (Math.pow(first + second, 2) == i) {

				System.out.println(i);
			}
		}

		// Smart way. Reduces number of loop iterations significantly. The
		// Square of three digit numbers less than 317 is not a six digit number
		// hence the loop starts with 317.

		for (int i = 317; i < 1000; i++) {

			int potential = (int) Math.pow(i, 2);

			int first = potential / 1000;

			int second = potential % 1000;

			if (Math.pow(first + second, 2) == potential) {

				System.out.println(potential);
			}
		}
	}

	/**
	 * This was asked in Amazon phone screen.
	 * 
	 * @param limit
	 */
	public void firstNPrimeNumbers(int limit) {

		if (limit > 0) {

			int count = 0;
			int num = 1;
			boolean divisible = false;

			while (count <= limit) {

				for (int i = 2; i < num; i++) {

					if (num % i == 0) {

						divisible = true;

						break;
					}
				}
				if (!divisible) {

					System.out.print(num + "\t");
					count++;
				}
				divisible = false;
				num++;
			}
		}
	}

	public int countTotalDigits(int number) {

		int count = 0;

		while (number != 0) {

			number = number / 10;

			count++;
		}

		return count;
	}

	/**
	 * 
	 * The method takes in an integer as an argument and returns its
	 * corresponding binary number. Will this method handle negative integers?
	 * NO
	 * 
	 * @param num
	 * @return
	 */
	public String getBinary(int num) {

		Stack<Byte> binary = new Stack<Byte>();

		byte remainder = 0;

		while (num > 0) {

			remainder = (byte) (num % 2);

			binary.push(remainder);

			num = num / 2;
		}

		StringBuilder builder = new StringBuilder();

		while (!binary.isEmpty()) {

			builder.append(binary.pop());
		}

		return builder.toString();
	}

	/**
	 * Amazon on-site. Calculate the final score of a student using the scores
	 * from quiz and tests. Average of all quiz score should be treated as 1
	 * test score.
	 * 
	 * The interviewer added a twist with the following criteria. 1. What if the
	 * professor decides not to include the lowest score in the final score 2.
	 * What if the professor decides to double the score of the last test.
	 * 
	 * @param quizScore
	 * @param testsScore
	 * @return
	 */
	public int score(int[] quizScore, int[] testsScore, boolean omitMin,
			boolean doubleLast) {

		int[] finalScores;

		int newLength = testsScore.length + 1;

		if (omitMin) {

			newLength = testsScore.length;
		}

		finalScores = new int[newLength];

		int quizAverage = average(quizScore);

		int minIndex = -1;

		if (omitMin) {

			int min = 0;

			for (int i = 0; i < testsScore.length; i++) {

				if (testsScore[i] > min) {

					minIndex = i;
					min = testsScore[i];
				}
			}
		}

		int count = 0;
		for (int i = 0; i < finalScores.length - 1; i++) {

			if (i != minIndex) {

				finalScores[i] = testsScore[count];
			} else {

				count++;
			}
			count++;
		}

		if (doubleLast) {

			finalScores[finalScores.length - 2] *= 2;
		}

		finalScores[finalScores.length - 1] = quizAverage;

		return average(finalScores);
	}

	public int average(int[] array) {

		if (array == null || array.length == 0) {

			return 0;
		}

		int sum = 0;

		for (int result : array) {

			sum += result;
		}

		return sum / array.length;
	}

	/**
	 * when b is even pow(a,b) = pow(a^2, b/2); when b is odd pow(a, b) =
	 * a*pow(a^2, b/2);
	 * 
	 * for odd and even b, right shifting the bits by one is equivalent to
	 * dividing b by 2.so use b=b>>1, instead of division. also note that one
	 * can check if b is even or odd by this bit operation: if(b&01 == 1)
	 * implies that b is odd.
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double pow(double base, int exponent) {
		boolean NegExp = false;
		double result = 1;
		if (exponent == 0)
			return 1;
		if (base == 0)
			return 0;
		if (exponent < 0) {
			NegExp = true;
			exponent *= -1;
		}
		while (exponent > 0) {
			if ((exponent & 1) == 1)
				result *= base;
			base *= base;
			exponent = exponent >> 1;
		}
		if (NegExp)
			result = 1 / result;
		return result;
	}

	public int findMajorityElement(int arr[]) {
		if (arr == null)
			return Integer.MIN_VALUE;
		int length = arr.length;
		int majorIndex = 0;
		int count = 1;
		for (int i = 0; i < length; i++) {
			if (arr[majorIndex] == arr[i])
				count++;
			else
				count--;
			if (count == 0) {
				majorIndex = i;
				count = 1;
			}
		}
		return arr[majorIndex];
	}

	public int getMajority(int arr[]) {
		if (arr == null || arr.length == 0)
			return -1;
		int element = findMajorityElement(arr);
		int length = arr.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] == element)
				count++;
		}
		if (count > length / 2)
			return element;
		return -1;
	}

	// Usage: int[] denoms = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
	// System.out.println(ways(denoms, denoms.length, 200));
	public static int ways(int denoms[], int index, int capacity) {
		if (capacity == 0)
			return 1;
		if (capacity < 0 || index <= 0)
			return 0;
		int withoutItem = ways(denoms, index - 1, capacity);
		int withItem = ways(denoms, index, capacity - denoms[index - 1]);
		return withoutItem + withItem;
	}

	/**
	 * Sort an array having only zeros and once. This is a very simple version
	 * of QuickSort without having to partition the data structure and without
	 * having to swap the values. Swapping is an expensive operation and can be
	 * avoided in this case because we know the only values the array holds is
	 * 0s and 1s.
	 * 
	 * @param array
	 */
	public void arraysWithZerosAndOnes(int array[]) {

		int length = array.length;

		if (array != null && length > 0) {

			int i = 0;
			int j = length - 1;

			while (i < j) {

				while (array[i] == 0) {

					i++;
				}
				while (array[j] == 1) {

					j--;
				}

				if (i < j) {
					array[i] = 0;
					array[j] = 1;
				}
			}
		}

		for (int i : array) {

			System.out.print(i + "\t");
		}
	}

	public int getDigits(int number, int digits) {

		return number
				/ (int) (Math.pow(10, Math.floor(Math.log10(number)) - digits));
	}

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 * 
	 *         Amazon phone screen. Given party of 10 people distribute cake in
	 *         such a way that every 8th person should receive a cake exactly
	 *         once. Return the last person who did not receive the cake.
	 * 
	 *         This problem is broadly called Josephus's problem and can be
	 *         solved as follows.
	 */
	public int remaining(int n, int k) {
		int r = 0;
		for (int i = 2; i <= n; i++)
			r = (r + k) % i;

		return r;
	}

	/**
	 * Yahoo phone interview. I wrote this program as per the standard condition
	 * checks. The interviewer suggested how to make it more readable.
	 */
	public void fizzBuzz() {

		for (int i = 1; i <= 100; i++) {

			// Setting the variables as follows makes the code more readable.
			boolean fizzBuzz = (i % 3 == 0 && i % 5 == 0);
			boolean fizz = i % 3 == 0;
			boolean buzz = i % 5 == 0;

			if (fizzBuzz) {

				System.out.println("FizzBuzz");
			} else if (fizz) {

				System.out.println("Fizz");
			} else if (buzz) {

				System.out.println("Buzz");
			}
		}
	}

	public int findPairWithMaxDifference(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i : array) {
			if (i < min) {
				min = i;
			} else if (i > max) {
				max = i;
			}
		}
		return max - min;
	}
}