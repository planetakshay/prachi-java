package practice2023.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class EmployeeFreeTime {
    public List<TimeInterval> employeeFreeTime(List<List<TimeInterval>> schedule) {
        Queue<TimeInterval> free = new PriorityQueue<>((i1, i2) -> i1.start - i2.start);
        List<TimeInterval> res = new ArrayList<>();
        for (List<TimeInterval> list : schedule) {
            free.addAll(list);
        }
        while (free.size() > 1) {
            TimeInterval first = free.poll();
            TimeInterval second = free.poll();
            if (second.start > first.end) {
                res.add(new TimeInterval(first.end, second.start));
            }
            if (first.end > second.end) {
                free.add(first);
            } else {
                free.add(second);
            }
        }
        return res;
    }
}

class TimeInterval {
    public int start;
    public int end;

    public TimeInterval() {
    }

    public TimeInterval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}