package practice2023.array;

import java.util.Arrays;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int[] ans = new int[arr1Len];

        int k = 0;
        for(int i=0;i<arr2Len;i++) {
            for(int j=0;j<arr1Len;j++) {
                if(arr2[i] == arr1[j]) {
                    ans[k++] = arr2[i];
                    arr1[j] = -1;
                }
            }
        }

        Arrays.sort(arr1);
        for(int i=0;i < arr1Len; i++) {
            if(arr1[i] != -1) {
                ans[k++] = arr1[i];
            }
        }
        return ans;
    }

}
