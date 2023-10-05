package practice2023;

public class SubstringFirstOccurence {

    public static int strStr(String haystack, String needle) {
        if(haystack.isBlank() || needle.isBlank()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
