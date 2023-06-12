package practice2023;

public class ValidNumber {

    public static void main(String[] args) {
        System.out.println("4.325 isValidNumber: " + isValidNumber("4.325"));
        System.out.println("-3.14 isValidNumber: " + isValidNumber("-3.14"));
        System.out.println("1.1.1 isValidNumber: " + isValidNumber("1.1.1"));
        System.out.println("28.prachi isValidNumber: " + isValidNumber("28.prachi"));
        System.out.println("prachi.deodhar isValidNumber: " + isValidNumber("prachi.deodhar"));
    }

    public static boolean isValidNumber(String input) {
        if (input.isBlank()) {
            return false;
        }
        int periodCount = 0;
        for (char curr : input.toCharArray()) {
            if (periodCount > 1) return false;
            if (curr == '.') {
                periodCount++;
            } else if (curr != '-' && !Character.isDigit(curr)) {
                return false;
            }
        }
        return true;
    }
}
