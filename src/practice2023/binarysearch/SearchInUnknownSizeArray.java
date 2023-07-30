package practice2023.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInUnknownSizeArray {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        Listy listy = new Listy(list);
        int target = 16;
        System.out.println("Element found at: " + search(listy, target));
    }

    public static int search(Listy list, int target) {
        if(list == null) {
            return -1;
        }
        int index = 1;
        while(list.elementAt(index) != -1 && list.elementAt(index) < target) {
            index *= 2;
        }
        return binarySearch(list, target, index / 2, index);
    }
    public static int binarySearch(Listy list, int target, int start, int end) {
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            int middle = list.elementAt(mid);
            if(middle > target || middle == -1) {
                end = mid - 1;
            } else if(middle < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

class Listy{
    List<Integer> list;

    public Listy() {
        list = new ArrayList<>();
    }

    public Listy(List<Integer> list) {
        this.list = list;
    }
    public int elementAt(int index) {
        if(index < 0 || index > list.size()) {
            return -1;
        }
        return list.get(index);
    }
}
