package practice2023.sorting;

import java.util.List;

/**
 * Sort character array in non-decreasing order of their ascii values
 * ascii value range is 0 - 127.
 * There are 128 total ascii characters.
 * <p>
 * IK sorting algorithm practice set 2.
 *
 * Since there is a defined range of values
 * counting sort will be best for optimal solution.
 *
 */
public class CharacterSort {
    static List<Character> sortCharArray(List<Character> arr) {
        if (arr == null || arr.size() == 0) {
            return arr;
        }
        int[] freq = new int[128];
        for (char ch : arr) {
            freq[ch]++;
        }
        arr.clear();
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < freq[i]; j++) {
                char ch = (char) i;
                arr.add(ch);
            }
        }
        return arr;
    }
}