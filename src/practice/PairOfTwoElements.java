package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
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
	class Pair{
		int num1;
		int num2;
		Pair(int num1,int num2){
			this.num1=num1;
			this.num2=num2;
		}
	}
	Map<Integer,List<Pair>> pairMap = new HashMap<Integer,List<Pair>>();
	
	public  void store(int num) {

		if (data.size() >= 1) {

			for (int element : data) {

				pairSummation.add(element + num);
				
				if(pairMap.containsKey(element+num)){
					List<Pair> pairs = pairMap.get(element+num);
					pairs.add(new Pair(element,num));
					pairMap.put(element+num, pairs);	
				}else{
					
					List<Pair> pairs = new ArrayList<Pair>();
					pairs.add(new Pair(element,num));
					pairMap.put(element+num, pairs);
				}
			}
		}

		data.add(num);
	}

	public boolean test(int sum) {
		return pairSummation.contains(sum);
	}
	
	public List<Pair> getPairs(int sum){
		if(pairSummation.contains(sum)){
			return pairMap.get(sum);
		}
		
		return null;
	}
			
	public static void main(String args[]){
		PairOfTwoElements poe = new PairOfTwoElements();
		int[] array = new int[]{3,4,5,6,7,8,9,10,5,13,11,2};
		for(int i: array){
			poe.store(i);
		}
		
		if(poe.test(10)){
			List<Pair> pairs = poe.getPairs(13);
			if(pairs!=null){
				for(Pair p : pairs){
					System.out.println(p.num1+ " , " +p.num2);
				}
			}
			
		}
	}
}
