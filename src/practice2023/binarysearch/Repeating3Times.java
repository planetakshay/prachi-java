package practice2023.binarysearch;

public class Repeating3Times {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
        System.out.println("Element repeating 3 times: " + findRepeatingThrice(arr));
    }

    public static int findRepeatingThrice(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        for(int i=0; i < arr.length - 2; i += 2) {
            if(arr[i] == arr[i + 2]) {
                return arr[i];
            }
        }
        return -1;
    }
}
