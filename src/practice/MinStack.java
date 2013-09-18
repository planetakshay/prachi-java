package practice;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();

	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(Integer value) {

		if (stack.size() == 0) {
			minStack.push(value);
		} else {
			Integer currentMin = minStack.peek();
			if (currentMin >= value) {
				minStack.push(value);
			}
		}
		stack.push(value);
	}

	public Integer pop() {

		Integer value = null;

		if (stack.size() > 0) {
			value = stack.pop();
		}

		if (minStack.size() > 0) {

			Integer currentMin = minStack.peek();

			if (currentMin == value) {

				minStack.pop();
			}
		}

		return value;
	}

	public Integer getMin() {

		if (minStack.size() > 0) {

			return minStack.peek();
		}
		return Integer.MIN_VALUE;
	}

	public Integer size() {

		return stack.size();
	}

	public static void main(String args[]) {

		MinStack minStack = new MinStack();

		minStack.push(19);
		minStack.push(11);
		minStack.push(19);

		System.out.println("Current Min: " + minStack.getMin());

		minStack.push(3);
		minStack.push(14);
		minStack.push(3);
		minStack.push(6);

		System.out.println("Current Min: " + minStack.getMin());

		minStack.push(7);
		minStack.push(28);
		minStack.push(8);
		minStack.push(8);

		System.out.println("Current Min: " + minStack.getMin());

		minStack.push(2);

		minStack.push(1);

		System.out.println("Current Min: " + minStack.getMin());

		while (minStack.size() > 0) {

			minStack.pop();

			System.out.println("Minimum in the stack: " + minStack.getMin()
					+ "\nStack Size: " + minStack.stack.size());
		}
	}
}
