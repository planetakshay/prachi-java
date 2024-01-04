package practice2023.strings;

public class CountCharacter {

    public static void main(String[] args) {
        CountCharacter character = new CountCharacter();
        System.out.println("Count occurrences: " + character.countCharacter("aadfdweraadaaewrwnnnfambjdfadkfakjkdfjcznvnkfrer", 'p'));
    }

    private int countCharacter(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int[] occurrences = new int[26];
        for (char c : str.toLowerCase().toCharArray()) {
            occurrences[c - 'a']++;
        }
        return occurrences[ch - 'a'];
    }
}
