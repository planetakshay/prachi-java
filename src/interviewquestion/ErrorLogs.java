package interviewquestion;
/*

We are building a log monitoring application where we can see errors/exceptions using query criteria
Making it simple, lets say we are getting log events as
ERROR1 ,10
ERROR2, 20
ERROR3, 30
ERROR1, 40
ERROR1, 60

Record these error => void record(String event)
Get count of errors
List<String> getErrorCount(String query, String frequency, int startTime, int endTime)
Eg -
getErrorCount(“ERROR1”, “minute”, 0, 130)
[0,59] [60,119] [120,130]
=> [2, 1, 0]
getErrorCount(“ERROR1”, “minute”, 0, 60)
=> [2,1]
[0,59] => 2
[59,60] => 1
getErrorCount(“ERROR1”, “hour”, 0, 3600)


ERROR1 ,10
ERROR1 ,10
ERROR2, 20
ERROR3, 30
ERROR1, 40
ERROR1, 60



getErrorCount(“ERROR1”, “minute”, 0, 130)
[0,59] [60,119] [120,130]


getErrorCount(“ERROR1”, “minute”, 20, 130)
[20,79], [80,130]
[2,0]

 */

import java.util.*;

public class ErrorLogs {
    Map<String, List<Integer>> rawLogs;

    public ErrorLogs() {
        rawLogs = new HashMap<>();
    }

    public static void main(String[] args) {
        ErrorLogs errorLogs = new ErrorLogs();
        errorLogs.record("ERROR1 ,10");
        errorLogs.record("ERROR1 ,10");
        errorLogs.record("ERROR2, 20");
        errorLogs.record("ERROR3, 30");
        errorLogs.record("ERROR1, 40");
        errorLogs.record("ERROR1, 60");

        System.out.println(errorLogs.getErrorCount("ERROR1", "Minute", 20, 130));

        System.out.println(errorLogs.getErrorCount("ERROR1", "Minute", 0, 60));

    }
    public void record(String event) {
        String[] parts = event.split(",");
        if(parts != null && parts.length == 2) {
            int timestamp = Integer.parseInt(parts[1].trim());
            String type = parts[0].trim();
            rawLogs.putIfAbsent(type, new ArrayList<>());
            rawLogs.get(type).add(timestamp);
        }
    }

  /*
    - start - 20, end - 130
    - findRanges(frequency, start, end) => [20,79], [80,130]
    - findCountFor eachRange [20,79], ERROR1
    - 20, 21,22 ..... 79 => 60 times =>
    - ERROR1, [10,10,40,60.....]
    -> 1 key => get list , 10 instances => 5 times end of endTime
    */

    List<String> getErrorCount(String query, String frequency, int startTime, int endTime) {
        List<String> matching = new ArrayList<>();

        if(rawLogs.containsKey(query)) {
            List<Integer> timestamps = rawLogs.get(query);

            int count = 0;
            int start = startTime;
            int end = endTime;

            while(end <= endTime) {
                count = 0;
                end = start + 59;
                for(int time : timestamps) {
                    if(time > start && time < end) {
                        count++;
                    }
                }
                matching.add(String.valueOf(count));
                start = end + 1;
            }
        }
        return matching;
    }
}