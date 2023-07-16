package practice2023.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * <p>
 * Important thing to remember in this problem is, since Strings in Java
 * are immutable we will have to sort the character array of each input string
 * sort it and then create a new string object with the sorted string.
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(list -> System.out.print(Arrays.toString(list.toArray())));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray(); // Very important to initialize in a new variable.
            Arrays.sort(charArr);
            String copy = new String(charArr);
            List<String> existing = groups.getOrDefault(copy, new LinkedList<>());
            existing.add(str);
            groups.put(copy, existing);
        }
        return List.copyOf(groups.values());
    }
}