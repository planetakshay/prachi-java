package practice;

import java.util.ArrayList;

public class StackUsingArrayList<E> extends ArrayList<E> {

	//public static final long serialID=1L;
		
	public E pop(){
		E e = get(size()-1);
		remove(size()-1);
		return e;
	}
	
	public void push(E e){
		add(e);
	}
	
	public static void main(String args[]) {
		
		StackUsingArrayList<Integer> stack = new StackUsingArrayList<Integer>();
		
		stack.push(100);
		System.out.println("Popped Element: " + stack.pop());
	}
}

