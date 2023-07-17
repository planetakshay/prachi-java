package practice2023.binarysearch;

/**
 * Search a given string in a sorted string array with
 * empty strings interspersed.
 *
 * The below solution uses a modified version of binary search
 * where we move the mid to the closes non-empty string, and then
 * search for the target using binary search.
 *
 * The average case time complexity is O(log n) and worst is O(N)
 * when we have almost all strings empty but one.
 *
 * Ask the interviewer is target search term can be "". In that case
 * there will be multiple answers. In my opinion the empty search target
 * string should return -1.
 *
 */
public class FindString {

    public static void main(String[] args) {
        String[] strings = new String[]{"at", "", "", "", "ball", "", "", "cat", "", "","dad","",""};
        String str = "ball";
        System.out.println(str+ " found at: " + search(strings, str));
    }

    public static int search(String[] strings, String str) {
        if(strings == null || strings.length == 0 || str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length-1);
    }

    public static int search(String[] strings, String str, int first, int last) {
        if(first > last) {
            return -1;
        }
        int mid = (first + last) / 2;
        if(strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while(true) {
                if(left < first && right > last) { // out of bounds.
                    return -1;
                } else if(right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if(left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        if(str.equals(strings[mid])) {
            return mid;
        } else if(strings[mid].compareTo(str) < 0) {
            return search(strings, str, mid + 1, last);
        } else {
            return search(strings, str, first, mid - 1);
        }
    }
}
