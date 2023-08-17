package practice2023.queue;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/logger-rate-limiter/description/
 */
public class LoggerRateLimiter {
    private final LinkedList<Pair<String, Integer>> msgQueue;
    private final HashSet<String> msgSet;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        msgQueue = new LinkedList<Pair<String, Integer>>();
        msgSet = new HashSet<String>();
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        boolean shouldPrintMsg = logger.shouldPrintMessage(1, "foo");
        shouldPrintMsg = logger.shouldPrintMessage(2, "bar");
        System.out.println("shouldPrintMsg: " + shouldPrintMsg);
        shouldPrintMsg = logger.shouldPrintMessage(3, "foo");
        System.out.println("shouldPrintMsg: " + shouldPrintMsg);
        shouldPrintMsg = logger.shouldPrintMessage(8, "bar");
        System.out.println("shouldPrintMsg: " + shouldPrintMsg);
        shouldPrintMsg = logger.shouldPrintMessage(10, "foo");
        System.out.println("shouldPrintMsg: " + shouldPrintMsg);
        shouldPrintMsg = logger.shouldPrintMessage(11, "foo");
        System.out.println("shouldPrintMsg: " + shouldPrintMsg);
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // clean up.
        while (msgQueue.size() > 0) {
            Pair<String, Integer> head = msgQueue.getFirst();
            if (timestamp - head.second >= 10) {
                msgQueue.removeFirst();
                msgSet.remove(head.first);
            } else {
                break;
            }
        }

        if (!msgSet.contains(message)) {
            Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
            msgQueue.addLast(newEntry);
            msgSet.add(message);
            return true;
        }
        return false;
    }

    class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}