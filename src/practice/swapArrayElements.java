package practice;

/*
 * This program swaps array elements using generics.
 * This enables us to pass any type of array as an argument and still have
 * elements swapped. This also prints the same array.
 */
public class swapArrayElements {
	
	public static <T> void swap(T[]a,int i,int j){
		T temp=null;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	public static <T>void printArray(T[] a){
		
		for(T i: a){
			System.out.print(i+",");
		}
		
		
	}
	public static void main(String args[]){
		Double[] doubleArray = new Double[]{10.0,3.0,4.0};
		int[] intArray= new int[]{3,4,5,2};
		swap(doubleArray, 0, 2);
		printArray(doubleArray);
		String [] stringArray = new String[]{ "Akshay","Prachi","Samarth"};
		swap(stringArray,1,2);
		printArray(stringArray);
	}
	
}
