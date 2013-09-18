package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

/**
 * 
 * LinkedIn phone screen.
 * 
 * Write a method that will return true of false if there exists a pair in the
 * collection that is equal to the given sum.
 * 
 * @author Prachi
 * 
 */
public class PairOfTwoElements {

	Set<Integer> pairSummation = new HashSet<Integer>();

	List<Integer> data = new LinkedList<Integer>();

	public void store(int num) {

		if (data.size() >= 1) {

			for (int element : data) {

				pairSummation.add(element + num);
			}
		}

		data.add(num);
	}

	public boolean test(int sum) {

		return pairSummation.contains(sum);
	}
}
