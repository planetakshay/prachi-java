package practice;

public class MatrixRotation {
	public static void main(String args[]) {
		int matrix[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(matrix);
		int[][] rotated = rotate(matrix);
		System.out.println("--------------------------------------");
		print(rotated);
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] rotate(int[][] matrix) {

		int length = matrix.length - 1;
		int row = matrix.length;
		int column = matrix.length;
		int temp = 0;

		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < (column + 1) / 2; j++) {
				System.out.println("--------------------------------------");
				temp = matrix[i][j];
				matrix[i][j] = matrix[length - j][i];
				print(matrix);
				System.out.println("--------------------------------------");
				matrix[length - j][i] = matrix[length - i][length - j];
				print(matrix);
				System.out.println("--------------------------------------");
				matrix[length - i][length - j] = matrix[j][length - i];
				print(matrix);
				System.out.println("--------------------------------------");
				matrix[j][length - i] = temp;
				print(matrix);
				System.out.println("--------------------------------------");
			}
		}
		return matrix;
	}
}
