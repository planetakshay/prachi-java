package practice2023.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input:
 *
 * messageId: "msg1"  timestamp: 1000
 *
 * messageId: "msg1"  timestamp: 1100
 *
 * messageId: "msg2"  timestamp: 1000;
 *
 * messageId: "msg1"  timestamp: 2000;
 *
 * messageId: "msg2"  timestamp: 3000;
 */

public class QueryLogs {
    Map<String, List<Long>> logMap;
    Map<Long, List<String>> timestampToLog;

    public QueryLogs() {
        this.logMap = new HashMap<>();
    }

    public static void main(String[] args) {
        QueryLogs queryLogs = new QueryLogs();
        queryLogs.insert("msg1", 1000);
        queryLogs.insert("msg5", 1000);
        queryLogs.insert("msg2", 2000);
        queryLogs.insert("msg3", 4000);
        queryLogs.insert("msg1", 1010);
        queryLogs.insert("msg1", 1020);

        System.out.println(queryLogs.countByRange("msg1", 900, 1200));
    }

    public List<long[]> buildRanges(long start, long end) {
        List<long[]> intervals = new ArrayList<>();
        long currS = start;

        while (currS <= end) {
            long currE = Math.min(currS + 59, end);
            intervals.add(new long[]{currS, currE});
            currS += 60;
        }
        return intervals;
    }

    public List<Integer> countByRange(String msgId, long start, long end) {
        List<long[]> ranges = buildRanges(start, end);
        List<Integer> res = new ArrayList<>();
        for (long[] interval : ranges) {
            int count = 0;
            List<Long> eventTime = logMap.get(msgId);
            for (long time : eventTime) {
                if (time >= interval[0] && time <= interval[1]) {
                    count++;
                }
            }
            if (count > 0) {
                res.add(count);
            }
        }
        return res;
    }

    public void insert(String msgId, long timestamp) {
        List<Long> timestamps = logMap.getOrDefault(msgId, new ArrayList<>());
        timestamps.add(timestamp);
        logMap.put(msgId, timestamps);
    }
}