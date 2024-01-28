package practice2023.strings;

public class RemoveVowels {
    public String removeVowels(String s) {
        if (s == null || s.isBlank()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!isVowel(ch)) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}