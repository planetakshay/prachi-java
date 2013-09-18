package practice;

public class RepeatedChar {

	// given a string, return start position of largest repeated characters
	public static int posOfLargestRepeatedChars(String string) {

		if (string == null || string.length() == 0) {
			return -1;
		}
		char[] str = string.toCharArray();
		int start = 0;
		int potential_start = 0;
		int count = 1;
		int maxCount = 1;

		for (int i = 1; i < str.length; i++) {
			if (str[i] == str[i - 1]) {
				count++;
				if (count > maxCount) {
					maxCount = count;
					start = potential_start;
				}

			} else {
				potential_start = i;
				count = 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		//String string = "aaaaabbbbbbbbbbbbbbefxsscc";
		String string = "aaaaaaaaabaacabb";
		System.out.println(posOfLargestRepeatedChars(string));
	}
}