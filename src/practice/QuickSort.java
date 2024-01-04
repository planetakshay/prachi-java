package practice;

/**
 * 
 * @author Prachi
 * 
 *         Kaboodle on-site (Year 2007). Didn't solve that sorting problem using
 *         QuickSort. Used BubbleSort as that was the only algorithm I prepared
 *         for the sort operations.
 * 
 *         This has NlogN efficiency and sorts in-place
 * 
 */
public class QuickSort {

	public static void main(String args[]) {
		int array[] = new int[] { 19, 11, 19, 3, 14, 3, 6, 7, 28, 8, 8 };
		//array = new int[] { 3, 5, 8, 1, 9,4, 6, 7, 3, 2};
		QuickSort.sort(array, 0, array.length - 1);
		for (int ele : array) {
			System.out.print(ele + "\t");
		}
	}
	public static int partition(int array[], int start, int end) {
		int i = start;
		int j = end;
		int temp = 0;
		if (array != null && array.length > 1) {
			int pivot = array[(start + end) / 2];
			while (i <= j) {
				while (array[i] < pivot) {
					i++;
				}
				while (array[j] > pivot) {
					j--;
				}
				if (i <= j) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				}
			}
		}
		return i;
	}
	public static void sort(int[] array, int start, int end) {
		int index = partition(array, start, end);
		if (start < index - 1) {
			sort(array, start, index - 1);
		}
		if (end > index) {
			sort(array, index, end);
		}
	}
}