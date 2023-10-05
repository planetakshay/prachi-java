package practice2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CartesianProduct {

    public static List<String> cartesianProduct(List<String> first, List<String> next) {
        List<String> product = new ArrayList<>();
        for(int i = 0; i< first.size();i++) {
            for(int j = 0; j < next.size();j++) {
                String comb = "{" + first.get(i) + ", " + next.get(j) + "}";
                product.add(comb);
            }
        }
        return product;
    }

    public static List<String> cartesianProductEfficient(List<String> first, List<String> next) {
        List<String> product = new ArrayList<>();
        Map<String, String> mapping = new HashMap<>();

        for(int i = 0; i< first.size();i++) {
            for(int j = 0; j < next.size();j++) {
                String comb = "{" + first.get(i) + ", " + next.get(j) + "}";
                product.add(comb);
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println("Cartesian Product" + cartesianProduct(Arrays.asList("1", "2", "3"), Arrays.asList("4", "5", "6")));
    }
}
