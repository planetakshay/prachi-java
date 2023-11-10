package practice;

/**
 * 
 * @author Prachi
 * 
 *         Yahoo on-site
 * 
 */
public class Pascal {

	public static void main(String[] args) {
		int n = 10;
		int[] row = new int[0];
		for (int i = 0; i < n; i++) {
			// Calculate next row
			row = pascalRow(row);
			// Now output the row values
			for (int j = 0; j < row.length; j++) {
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
		pascalWith2DArray(n);
	}

	public static int[] pascalRow(int[] previous) {
		// Row is 1 element longer than previous row
		int[] row = new int[previous.length + 1];
		// First and last numbers in row are always 1
		row[0] = 1;
		row[row.length - 1] = 1;
		// The AtlassianRest of the row can be
		// calculated based on previous row
		for (int i = 1; i < row.length - 1; i++) {
			row[i] = previous[i - 1] + previous[i];
		}
		return row;
	}

	public static void pascalWith2DArray(int n) {
		int[][] pascal = new int[n + 1][];
		// initialize first row
		pascal[1] = new int[1 + 2];
		pascal[1][1] = 1;
		// fill in Pascal's triangle
		for (int i = 2; i <= n; i++) {
			pascal[i] = new int[i + 2];
			for (int j = 1; j < pascal[i].length - 1; j++)
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
		}
		// print results
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < pascal[i].length - 1; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}
}