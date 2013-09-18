
package practice;

/**
 * This program prints words in a string in reverse order.
 * 
 * This was asked in Yahoo Phone screen(Year 2011)
 * HP - ArcSight onsite (Year 2013)
 * ProofPoint PhoneScreen.
 */

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] string = { 'I', ' ', ' ', 'l', 'o', 'v', 'e', ' ',' ', 'J', 'a',
				'v', 'a' };

		getWordsInReverseOrder(string);

		System.out.print(string);
	}

	/**
	 * @param inputString
	 */
	public static void getWordsInReverseOrder(char[] inputString) {

		if (inputString != null) {

			int wStartIndex = 0, wEndIndex = 0;

			// Reverse the string just by exchanging the character position.

			reverseString(inputString, wStartIndex, inputString.length - 1);

			// Reverse each word in the reversed string.

			while (wEndIndex < inputString.length) {

				while (wEndIndex < inputString.length
						&& inputString[wEndIndex] != 32) {

					wEndIndex++;
				}
				wEndIndex--;

				reverseString(inputString, wStartIndex, wEndIndex);

				wEndIndex += 2;

				wStartIndex = wEndIndex;

			}
		}
	}

	/**
	 * @param inputString
	 * @param start
	 * @param end
	 */
	private static void reverseString(char[] inputString, int start, int end) {

		char character;

		int wStartIndex = start;
		int wEndIndex = end;

		while (wEndIndex > wStartIndex) {

			character = inputString[wStartIndex];

			inputString[wStartIndex] = inputString[wEndIndex];

			inputString[wEndIndex] = character;

			wEndIndex--;

			wStartIndex++;
		}
	}
}