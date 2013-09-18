package practice;

/**
 * Given a plane calculate number of paths between origin(point(0,0)) and for
 * the given coordinate. Recursion is used to implement this. The idea is if any
 * of the coordinate is zero then possible path between that point and the
 * origin is always one. That becomes the terminating condition for the
 * recursion.
 * 
 * ProofPoint on-site.
 * 
 * @author Prachi
 * 
 */
public class Distance {

	public static void main(String args[]) {

		System.out.println("Recursive Solution: " + distanceRecursive(2, 2));

		System.out.println("Dynamic Programing Recursive Solution: "
				+ distanceDynamicProgramming(2, 2));
	}

	public static int distanceRecursive(int x, int y) {

		if (x == 0 || y == 0) {

			return 1;
		} else
			return distanceRecursive(x, y - 1) + distanceRecursive(x - 1, y);
	}

	public static int distanceDynamicProgramming(int x, int y) {

		int temp[][] = new int[50][50];

		// Intialization
		for (int i = 0; i <= x; i++) {
			temp[0][i] = 1;
		}
		for (int j = 0; j <= y; j++) {
			temp[j][0] = 1;
		}

		for (int i = 1; i <= y; i++) {
			for (int j = 1; j <= x; j++) {
				temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
			}
		}
		return temp[x][y];
	}
}