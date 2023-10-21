package practice2023.arraylist;

import java.util.ArrayList;

public class IntersectionOfThreeArrays {
    static ArrayList<Integer> find_intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        // Write your code here.
        ArrayList<Integer> interSection = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            if (arr1.get(i) == arr2.get(j) && arr2.get(j) == arr3.get(k)) {
                interSection.add(arr1.get(i));
                i++;
                j++;
                k++;
            } else {
                if(arr1.get(i) < arr2.get(j)) {
                    i++;
                } else if(arr2.get(j) < arr3.get(k)) {
                    j++;
                } else {
                    k++;
                }
            }
        }
        if(interSection.isEmpty()) {
            interSection.add(-1);
        }
        return interSection;
    }
}