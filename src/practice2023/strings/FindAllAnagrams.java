package practice2023.strings;

import java.util.*;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s,p);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new LinkedList<>();
        if(s == null || p == null) {
            return indices;
        }
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen) {
            return indices;
        }
        Map<Character, Integer> pFreq = new HashMap<>();
        for(char ch : p.toCharArray()) {
            pFreq.put(ch, pFreq.getOrDefault(ch, 0) +1);
        }
        Map<Character, Integer> sFreq = new HashMap<>();
        for(int i=0;i<sLen;++i) {
            char ch = s.charAt(i);
            sFreq.put(ch, sFreq.getOrDefault(ch, 0) +1);
            if (i >= pLen) {
                ch = s.charAt(i - pLen);
                if (sFreq.get(ch) == 1) {
                    sFreq.remove(ch);
                }
                else {
                    sFreq.put(ch, sFreq.get(ch) - 1);
                }
            }
            if (pFreq.equals(sFreq)) {
                indices.add(i - pLen + 1);
            }
        }
        return indices;
    }
}