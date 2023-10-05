package practice2023;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
    public static void main(String[] args) {
        Pascal pascal = new Pascal();
        System.out.println(pascal.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<Integer> row = new ArrayList<>(0);
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            row = pascalRow(row);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    public List<Integer> pascalRow(List<Integer> prev) {
        int prevSize = prev.size();
        int newSize = prevSize + 1;
        List<Integer> row = new ArrayList<>(newSize);
        row.add(0, 1);
        for(int i = 1; i < newSize - 1;i++) {
            row.add(i, prev.get(i-1) + prev.get(i));
        }
        if(newSize > 1) {
            row.add(newSize - 1, 1);
        }
        return row;
    }
}