package practice2023.binarysearch;

public class HIndex2 {

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1, 3, 6, 5};
        System.out.println("H-Index for given array: " + binarySearch(citations));

        citations = new int[]{1, 1, 3};
        System.out.println("H-Index for given array: " + binarySearch(citations));

        citations = new int[]{100};
        System.out.println("H-Index for given array: " + binarySearch(citations));
    }

    public static boolean hasAtLeastHCitations(int h, int[] citations) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }
        return count >= h;
    }

    public static int binarySearch(int[] citations) {
        int low = 0, high = citations.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (hasAtLeastHCitations(mid, citations)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
