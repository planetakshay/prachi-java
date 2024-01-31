package tutor;

import java.util.Arrays;
import java.util.Scanner;

public class TutorTest {
    /* public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 5, 6};
        int[] res = getIndex(arr, 6);

        for(int num : res) {
            if(num != 0) {
                System.out.print
            }
        }

    }

    public static int[] getIndex(int[] arr, int search) {
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                result[i] = i;
            }
        }
        return result;
    } */

    public static int[] findAll(int[] values, int searchedValue)
    {
        int[] result = new int[values.length];
        int resultSize = 0;

        int pos = -1;
        int index = 0;
        do
        {

            pos = findNext(values, searchedValue, index);
            if (pos > -1)
            {
                result[index] = pos;
                resultSize++;
            }
            index++;
        } while (index < values.length);
        /* Your code goes here */

        return result;
    }

    /**
     Finds the next occurrence of an element in an array.
     @param values an array of values
     @param searchedValue the value to search for
     @param start the position at which to start the search
     @return the position of the first match at position >= start,
     or -1 if the element was not found
     */
    public static int findNext(int[] values, int searchedValue, int start) // 31215926, 1, 1
    {
        int pos = 0;

        for (int i = start; i < values.length; i++) {
            if (values[i] == searchedValue) {
                pos = pos + i;
                System.out.println(pos);
                return pos;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String arrStr = in.nextLine();
        String[] strArray = arrStr.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++)
        {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        int searchedValue = in.nextInt();
        System.out.println(Arrays.toString(findAll(intArray, searchedValue)));
    }
}
