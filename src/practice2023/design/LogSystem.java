package practice2023.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LogSystem {
    TreeMap<Long, String> map;

    public LogSystem() {
        map = new TreeMap<>();
    }

    public void put(String logId, Long timestamp) {
        map.put(timestamp, logId);
    }

    public List<Integer> retrieve(String logId, long start, long end, String granularity) {
        List<Integer> count = new ArrayList<>();
        return count;
    }
}
