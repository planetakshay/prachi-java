package practice2023.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/crawler-log-folder/
 */
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            } else if (log.equals("../")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}