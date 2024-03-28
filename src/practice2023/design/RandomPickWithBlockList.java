package practice2023.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomPickWithBlockList {
    Map<Integer, Integer> map;
    int size = 0;
    Random random;

    public RandomPickWithBlockList(int n, int[] blacklist) {
        random = new Random();
        size = n - blacklist.length;
        int last = n - 1;
        map = new HashMap<>();
        for (int num : blacklist) {
            map.put(num, -1);
        }
        for (int num : blacklist) {
            if (num >= size) {
                continue;
            }
            System.out.println("Last: " + last);
            while (map.containsKey(last)) {
                last--;
            }
            map.put(num, last);
            last--;
        }
    }
    public int pick() {
        int num = random.nextInt(size);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
}