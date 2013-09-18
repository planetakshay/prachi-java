package practice;

public class addUsingGeneric {

	public static <T extends Number>double  addAndReturnDouble(T a, T b){
		return a.doubleValue()+b.doubleValue();
	}
	
	public static <T extends Number>int addAndReturnInteger(T a , T b){
		return a.intValue()+b.intValue();
	}
	public static void main(String args[]){
		//Using addAndReturnDouble
		System.out.println(addUsingGeneric.addAndReturnDouble(4f, 4.4));
		System.out.println(addUsingGeneric.addAndReturnDouble(5, 7l));
		
		//Using addAndReturnInteger
		System.out.println(addUsingGeneric.addAndReturnInteger(5l, 7.0));
		System.out.println(addUsingGeneric.addAndReturnInteger(5l, 7.9));
		System.out.println(addUsingGeneric.addAndReturnInteger(5.9f, 7.9));
		
	}

}
