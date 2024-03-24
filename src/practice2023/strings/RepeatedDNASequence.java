package practice2023.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        int size = 10;
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < len - size + 1; i++) {
            String seq = s.substring(i, i + size);
            if (!seen.add(seq)) {
                ans.add(seq);
            }
        }
        return new ArrayList<>(ans);
    }
}