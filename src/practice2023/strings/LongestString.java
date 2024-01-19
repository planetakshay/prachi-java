package practice2023.strings;
public class LongestString {

    public static String generateLongestString(int a, int b, int c) {
        StringBuilder string = new StringBuilder();
        int remainingA = a;
        int remainingB = b;
        int remainingC = c;

        while (remainingA > 0 || remainingB > 0 || remainingC > 0) {
            if (remainingA >= 2) {
                string.append("AA");
                remainingA -= 2;
            } else if (remainingA > 0) {
                string.append("A");
                remainingA--;
            }

            if (remainingB > 0) {
                string.append("AB");
                remainingB--;
            }

            if (remainingC > 0) {
                string.append("BB");
                remainingC--;
            }
        }

        return string.toString();
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int c = 4;
        String longestStr = generateLongestString(a, b, c);
        System.out.println("Longest string: " + longestStr);
    }
}