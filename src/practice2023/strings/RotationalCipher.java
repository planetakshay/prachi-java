package practice2023.strings;

/**
 * Hacker Rank problem.
 * Facebook career page had this as a problem in their
 * prep material/coding puzzle page.
 */
public class RotationalCipher {

    public static void main(String[] args) {
        String str = "All-convoYs-9-be:Alert1.";
        assert rotationalCipher(str, 4).equals("Epp-gsrzsCw-3-fi:Epivx5.");

        str = "abcdZXYzxy-999.@";
        assert rotationalCipher(str, 200).equals("stuvRPQrpq-999.@");
    }

    public static String rotationalCipher(String input, int rotationFactor) {
        if (input == null || input.length() == 0 || rotationFactor < 1) {
            return input;
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            char curr = ch;
            if (Character.isDigit(curr)) {
                builder.append((Character.getNumericValue(curr) + rotationFactor) % 10);
            } else if (Character.isLetter(curr)) {
                int begin = 0;
                if (Character.isLowerCase(curr)) {
                    begin = 'a';
                } else {
                    begin = 'A';
                }
                curr = (char) (begin + ((curr - begin) + rotationFactor) % 26);
                builder.append(curr);
            } else {
                builder.append(curr);
            }
        }
        return builder.toString();
    }
}
