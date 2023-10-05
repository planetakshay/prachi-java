package practice2023.strings;

import java.util.LinkedList;
import java.util.Queue;

public class SeparateNumbersWithComma {
    public static void main(String[] args) {
        String num = "327";
        System.out.println("No of combinations: " + numberOfCombinations(num));
    }
    public static int numberOfCombinations(String num) {
        if(num.startsWith("0")) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Character.getNumericValue(num.charAt(0)));
        String soFar = "";
        for(int i=1; i<num.length();i++) {
            soFar += num.charAt(i);

            if(queue.peek() < Integer.parseInt(soFar)) {
                queue.add(Integer.parseInt(soFar));
            }
        }
        int count=0;
        while(!queue.isEmpty()) {
            queue.poll();
            count++;
        }
        return count;
    }
}
