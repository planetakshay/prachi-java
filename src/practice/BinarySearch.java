package practice;

import java.util.Arrays;

/**
 * Example of binary search algorithm.
 * 
 * @author Prachi
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] array = { 89, 30, 40, 34, 30, 56, 81, 90, 65, 35 };

		Arrays.sort(array, 0, array.length - 1);

		int index = binarySearch(array, 0, array.length - 1, 89);

		System.out.println("index = " + index);

		int[] rotatedArray = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2 };

		System.out.println("Element in rotated Array found at index: "
				+ pivotedBinarySearch(rotatedArray, rotatedArray.length, 5));

		System.out
				.println("Element in rotated Array found at index: "
						+ searchInRotatedArray(rotatedArray, 0,
								rotatedArray.length, 9));

	}

	public static int binarySearch(int[] array, int start, int end, int item) {

		if (start > end) {

			return -1;
		}

		int pivot = (start + end) / 2;

		if (array[pivot] == item) {

			return pivot;

		} else if (array[pivot] > item) {

			return binarySearch(array, start, pivot - 1, item);

		} else {

			return binarySearch(array, pivot + 1, end, item);
		}
	}

	/*
	 * Searches an element no in a pivoted sorted array arrp[] of size arr_size
	 */
	public static int pivotedBinarySearch(int arr[], int arr_size, int no) {
		int pivot = findPivot(arr, 0, arr_size - 1);

		// If we didn't find a pivot, then array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, arr_size - 1, no);

		// If we found a pivot, then first compare with pivot and then
		// search in two subarrays around pivot
		if (arr[pivot] == no)
			return pivot;
		if (arr[0] <= no)
			return binarySearch(arr, 0, pivot - 1, no);
		else
			return binarySearch(arr, pivot + 1, arr_size - 1, no);
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will return 3
	 */
	public static int findPivot(int arr[], int low, int high) {
		if (high < low)
			return -1;

		int mid = (low + high) / 2; /* low + (high - low)/2; */
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		else
			return findPivot(arr, mid + 1, high);
	}

	// Non- Recursive solution.
	public static int searchInRotatedArray(int arr[], int low, int high, int num) {

		while (low <= high) {

			int pivot = (low + high) / 2;

			if (num == arr[pivot]) {

				return pivot;
			} else if (arr[low] <= arr[pivot]) {

				if (num > arr[pivot]) {

					low = pivot + 1;
				} else if (num >= arr[low]) {

					high = pivot - 1;
				} else {

					low = pivot + 1;
				}
			} else if (num < arr[pivot]) {

				high = pivot - 1;
			} else if (num <= arr[high]) {

				low = pivot + 1;
			} else {

				high = pivot - 1;
			}
		}

		return -1;
	}
}