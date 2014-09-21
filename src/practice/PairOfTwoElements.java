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
	class pair{
		int num1;
		int num2;
		pair(int num1,int num2){
			this.num1=num1;
			this.num2=num2;
		}
	}
	Map<Integer,List<pair>> pairMap = new HashMap<Integer,List<pair>>();
	
	public  void store(int num) {

		if (data.size() >= 1) {

			for (int element : data) {

				pairSummation.add(element + num);
				
				if(pairMap.containsKey(element+num)){
					List<pair> pairs = pairMap.get(element+num);
					pairs.add(new pair(element,num));
					pairMap.put(element+num, pairs);	
				}else{
					
					List<pair> pairs = new ArrayList<pair>();
					pairs.add(new pair(element,num));
					pairMap.put(element+num, pairs);
				}
			}
		}

		data.add(num);
	}

	public boolean test(int sum) {
		return pairSummation.contains(sum);
	}
	
	public List<pair> getPairs(int sum){
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
			List<pair> pairs = poe.getPairs(13);
			if(pairs!=null){
				for(pair p : pairs){
					System.out.println(p.num1+ " , " +p.num2);
				}
			}
			
		}
	}
}
