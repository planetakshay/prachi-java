package practice2023.design;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
public class ProductOfNumbers {
    List<Integer> arr;
    int last;
    public ProductOfNumbers() {
        init();
    }
    public void add(int num) {
        if (num > 0) {
            last *= num;
            arr.add(last);
        } else {
            init();
        }
    }
    public int getProduct(int k) {
        int size = arr.size();
        return k < size ? last / arr.get(size - k - 1) : 0;
    }
    private void init() {
        arr = new ArrayList<>();
        arr.add(1);
        last = 1;
    }
}