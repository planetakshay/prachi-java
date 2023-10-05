package practice2023.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AllOne {
    Map<String, Integer> freqMap;
   /* Stack<Pair> max;
    Stack<Pair> min;

    public AllOne() {
        freqMap = new HashMap<>();
        max = new Stack<>();
        min = new Stack<>();
    }

    public void inc(String key) {
        int count = freqMap.getOrDefault(key, 0);
        freqMap.put(key, count++);
        Pair currMax = max.peek();
        if (currMax == null) {
            currMax = new Pair();
            currMax.setKey(key);
            currMax.setMaxFreq(count);
            max.push(currMax);
        } else {
            Pair curr = new Pair();
            curr.setMaxFreq(count);
            curr.setKey(key);
            if (currMax.compareTo(curr) < 0) {
                max.push(curr);
            } else {
                // pop?
            }
        }
    }

    public void dec(String key) {
        int count = freqMap.getOrDefault(key, 0);
        if (count == 1) {
            if (getMinKey().equalsIgnoreCase(key)) {
                min.pop();
            }
            freqMap.remove(key);
        }
        freqMap.put(key, count--);
    }

    public String getMaxKey() {

    }

    public String getMinKey() {

    } */
}

/* class Pair implements Comparable {
    String key;
    Integer maxFreq;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getMaxFreq() {
        return maxFreq;
    }

    public void setMaxFreq(Integer maxFreq) {
        this.maxFreq = maxFreq;
    }

    @Override
    public int compareTo(Object o) {
        Pair temp = (Pair) o;
        return this.getMaxFreq().compareTo(temp.getMaxFreq());
    }
} */