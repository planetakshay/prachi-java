package practice;

import java.util.*;
import java.util.List;

/**
 * This example prints diagonals of a matrix. The example uses 3x3 matrix. This
 * can be used for any NxN matrix.
 * 
 * @author Prachi
 * 
 */
public class Matrix {

	public static void main(String args[]) {
		int array[][] = new int[][] { { 19, 3, 14 }, { 6, 28, 8 }, { 8, 7, 3 } };
		Matrix matrix = new Matrix();
		System.out.println("Main Diagonal\n");
		matrix.printMainDiagonal(array);
		System.out.println("\nSecond Diagonal\n");
		matrix.printSecondDiagonal(array);
		int array1[][] = new int[][] { { 10, 50, 80, 100 },
				{ 60, 70, 110, 130 }, { 85, 100, 120, 140 },
				{ 90, 200, 210, 300 } };
		System.out.println("\nElement 230 is found: "
				+ matrix.findElement(array1, 210, 4, 4));

		int array2[][] = new int[][] { { 210, 150, 480, 10000 },
				{ 960, 730, 10, 130 }, { 850, 100, 120, 140 },
				{ 900, 200, 210, 3000 } };
		System.out.println("Max Element in Array2: " + matrix.findMax(array2));
		matrix.printSpiralOrder(array);
		System.out.println("----------------------\n");
		int[][] reset = new int[][] { { 1, 2, 3, 4 }, { 0, 5, 6, 7 },
				{ 8, 0, 9, 10 } };
		matrix.printMatrix(reset);
		reset = matrix.resetValues(reset);
		System.out.println("Now printing Reset Values");
		matrix.printMatrix(reset);

		int[][] resetMatrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		matrix.printMatrix(resetMatrix);
		resetMatrix = matrix.resetValuesInPlace(resetMatrix);
		System.out.println("Now printing Reset Values with InPlace...........");
		matrix.printMatrix(resetMatrix);

		int[][] a = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> spiralOrder = matrix.printSpiralOrderLeetCode(a);
		System.out.println(Arrays.toString(spiralOrder.toArray()));

		array1 = new int[][]{{1, 3}};
		System.out.println("\nElement 3 is found: "
				+ matrix.findElement(array1, 3, 1, 2));
	}

	/**
	 *
	 * @param matrix
	 * @return
	 *
	 *         Yahoo on-site. For any cell with value 0 reset the corresponding
	 *         row and column values to zero.
	 *
	 *         If you set matrix's corresponding row and column value to zero as
	 *         you spot it the entire matrix will turn into zeros. Instead, save
	 *         row and column values in a set and later loop through the row and
	 *         column sets and set the row and columns to zero.
	 */
	public int[][] resetValues(int[][] matrix) {
		if (matrix == null) {
			return matrix;
		}
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (int row : rows) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[row][j] = 0;
			}
		}
		for (int col : cols) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][col] = 0;
			}
		}
		return matrix;
	}

	/**
	 * https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
	 *
	 * @param matrix
	 * @return
	 */
	public int[][] resetValuesInPlace(int[][] matrix) {
		if (matrix == null) {
			return matrix;
		}

		boolean isCol = false;
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Handle first cell only. And determine if first column or row needs to be
		// set to zero
		for(int i=0; i < rows; i++) {
			if(matrix[i][0] == 0) {
				isCol = true;
			}
			// Handle remaining of the metric.
			for(int j=1;j<cols;j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if(matrix[0][0] == 0) {
			for(int i=0;i<rows;i++) {
				matrix[0][i] = 0;
			}
		}

		if(isCol) {
			for(int i=0;i<rows;i++) {
				matrix[i][0] = 0;
			}
		}

		return matrix;
	}

	public void printMainDiagonal(int array[][]) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i][i] + "\t");
			}
		}
	}

	public void printSecondDiagonal(int array[][]) {
		if (array != null) {
			int n = array.length - 1;
			for (int i = 0; i <= n; i++) {
				System.out.print(array[n - i][i] + "\t");
			}
		}
	}

	// If rows and columns are sorted.
	public boolean findElement(int[][] matrix, int ele, int m, int n) {
		int row = 0;
		int col = n - 1;
		while (row < m && col >= 0) {
			if (matrix[row][col] == ele) {
				return true;
			} else if (matrix[row][col] > ele) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	public int findMax(int[][] matrix) {
		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > maxSoFar) {
					maxSoFar = matrix[i][j];
				}
			}
		}
		return maxSoFar;
	}

	/**
	 * Print an nxn matrix spirally. This algorithm is often asked in PayPal,
	 * eBay, Amazon.
	 *
	 * @param a
	 */
	public void printSpiralOrder(int a[][]) {
		int m = a.length, n = a[0].length;
		int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			int i = rowStart, j = colStart;
			for (j = colStart; j <= colEnd; j++)
				System.out.print(a[i][j] + " ");
			for (i = rowStart + 1, j--; i <= rowEnd; i++)
				System.out.print(a[i][j] + " ");
			for (j = colEnd - 1, i--; j >= colStart; j--)
				System.out.print(a[i][j] + " ");
			for (i = rowEnd - 1, j++; i > rowStart; i--)
				System.out.print(a[i][j] + " ");
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
		}
	}

	public List<Integer> printSpiralOrderLeetCode(int matrix[][]) {
		int m = matrix.length, n = matrix[0].length;
		int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
		List<Integer> spiral = new LinkedList<>();
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				spiral.add(matrix[rowStart][i]);
			}
			rowStart++;
			for (int i = rowStart; i <= rowEnd; i++) {
				spiral.add(matrix[i][colEnd]);
			}
			colEnd--;
			if(rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					spiral.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			if(colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					spiral.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}
		return spiral;
	}

	public void printMatrix(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}