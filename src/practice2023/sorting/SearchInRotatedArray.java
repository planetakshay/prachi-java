package practice2023.sorting;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] rotated = new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target = 2;
        System.out.println("Target = " + target + " found at: " + search(rotated, target));
    }

    public static int search(int[] rotated, int target) {
        if (rotated == null || rotated.length <= 1) {
            return 0;
        }
        return binarySearch(rotated, 0, rotated.length - 1, 2);
    }

    public static int binarySearch(int[] rotated, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (target == rotated[mid]) {
            return mid;
        }
        if(end < start) {
            return -1;
        }
        if (rotated[start] < rotated[mid]) {
            if (target >= rotated[start] && target < rotated[mid]) {
                return binarySearch(rotated, start, mid - 1, target);
            } else {
                return binarySearch(rotated, mid + 1, end, target);
            }
        } else if (rotated[start] > rotated[mid]) {
            if (target > rotated[mid] && target <= rotated[end]) {
                return binarySearch(rotated, mid + 1, end, target);
            } else {
                return binarySearch(rotated, start, mid - 1, target);
            }
        } else if (rotated[start] == rotated[mid]) {
            if (rotated[mid] != rotated[end]) {
                return binarySearch(rotated, mid + 1, end, target);
            } else {
                int result = binarySearch(rotated, start, mid - 1, target);
                if (result == -1) {
                    return binarySearch(rotated, mid + 1, end, target);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}