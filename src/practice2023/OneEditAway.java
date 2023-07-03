package practice2023;

public class OneEditAway {

    public static void main(String[] args) {
        String first = "pale";
        String second = "bale";
        System.out.println("Is one edit away: " + findOneDiffAway(first, second));

        first = "eat";
        second = "ate";
        System.out.println("Is one edit away: " + findOneDiffAway(first, second));

        first = "bel";
        second = "bell";
        System.out.println("Is one edit away: " + findOneDiffAway(first, second));

        first = "pale";
        second = "bae";
        System.out.println("Is one edit away: " + findOneDiffAway(first, second));

        first = "united states";
        second = "california";
        System.out.println("Is one edit away: " + findOneDiffAway(first, second));
    }

    public static boolean findOneDiffAway(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        // The diff more than 1 means needs more than 1 edit.
        if(Math.abs(lenS2 - lenS1) > 1) {
            return false;
        }
        // Initialize shorted and longer length strings.
        String shorter = (lenS2 > lenS1) ? s1 : s2;
        String longer = (lenS2 > lenS1) ? s2 : s1;

        int indLonger = 0, indShorter = 0;
        boolean foundDiff = false;

        while(indLonger < longer.length() && indShorter < shorter.length()) {
            if(shorter.charAt(indShorter) != longer.charAt(indLonger)) {
                if(foundDiff) {
                    return false;
                }
                foundDiff = true;
                if(lenS2 == lenS1) {
                    indShorter++;
                }
            } else {
                indShorter++;
            }
            indLonger++;
        }
        return true;
    }
}
