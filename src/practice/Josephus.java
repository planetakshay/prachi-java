package practice;

import java.util.ArrayList;

/**
 * 
 * @author Prachi
 * 
 *         This was asked in Amazon phone screen. This is based on Josephus
 *         problem. The problem phrase was a little different. Instead of
 *         killing kth person standing in a circle distribute a piece of cake to
 *         every kth person standing in a circle of n people. and the cake
 *         should be distributed in such a way the last person should not
 *         receive the cake and we need to return who didn't receive the cake.
 * 
 *         The following problem is solved for last one person or last m person
 *         who don't receive cake.
 */
public class Josephus {
	public static int execute(int n, int k) {
		int killIdx = 0;
		ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			prisoners.add(i);
		}
		System.out.println("Prisoners executed in order:");
		// Since we are dealing with indices starting with 0 while determining
		// the person to be killed at kth position we are taking k-1.
		while (prisoners.size() > 1) {
			killIdx = (killIdx + k - 1) % prisoners.size();
			System.out.print(prisoners.get(killIdx) + " ");
			prisoners.remove(killIdx);
		}
		System.out.println();
		return prisoners.get(0);
	}

	public static ArrayList<Integer> executeAllButM(int n, int k, int m) {
		int killIdx = 0;
		ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			prisoners.add(i);
		}
		System.out.println("Prisoners executed in order:");
		while (prisoners.size() > m) {
			killIdx = (killIdx + k - 1) % prisoners.size();
			System.out.print(prisoners.get(killIdx) + " ");
			prisoners.remove(killIdx);
		}
		System.out.println();
		return prisoners;
	}

	public static void main(String[] args) {
		System.out.println("Survivor: " + execute(41, 3));
		System.out.println("Survivors: " + executeAllButM(41, 3, 3));
	}
}