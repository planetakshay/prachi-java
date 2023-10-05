package practice2023.arraylist;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-items-matching-a-rule/description/
 */
public class ItemsMatchingRule {

    public static void main(String[] args) {
        List<List<String>> items = Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "lenovo"), Arrays.asList("phone", "gold", "iphone"));
        System.out.println("No of items matching rules: " + countMatches(items, "color", "silver"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        String compare = "";
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    compare = item.get(0);
                    break;
                case "color":
                    compare = item.get(1);
                    break;
                case "name":
                    compare = item.get(2);
                    break;
                default:
                    compare = "";
            }
            if (compare.equalsIgnoreCase(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
