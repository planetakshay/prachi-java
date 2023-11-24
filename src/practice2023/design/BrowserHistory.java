package practice2023.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The problem given is similar to leetcode question browerhistory
 * but different requirements were given.
 * https://leetcode.com/problems/design-browser-history/
 */
public class BrowserHistory {
    List<String> history;
    int index;

    public BrowserHistory(String url) {
        history = new ArrayList<>();
        history.add(url);
        index = history.size() - 1;
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("google.com");
        history.testCase(history);
        history = new BrowserHistory("momn.com");
        history.leetcodeTest(history);
    }

    public void testCase(BrowserHistory history) {
        history.visit("google.com");
        history.visit("fb.com");
        history.visit("microsoft.com");
        history.visit("yahoo.com");
        System.out.println("Back: " + history.back());
        System.out.println("Back: " + history.back());
        System.out.println("forward: " + history.forward());
        history.visit("twitter.com");
        history.visit("activision.com");
        System.out.println("forward: " + history.forward());
        System.out.println("forward: " + history.forward());
        System.out.println("Back: " + history.back());
        System.out.println("Most Recent: " + history.lastVisited());
    }

    /*
    ["BrowserHistory","visit","visit","back","visit","visit",
    "back","forward","visit","visit","visit","visit","visit",
    "visit","forward","forward","visit","back","visit","visit",
    "visit","visit","forward","visit","visit","visit"]

    [["momn.com"],["bx.com"],["bjyfmln.com"],[3],["ijtrqk.com"],["dft.com"],
    [10],[10],["yc.com"],["yhl.com"],["xynxvix.com"],["izfscdv.com"],["cdenhm.com"],
    ["ocgcjz.com"],[5],[5],["gtd.com"],[9],["hfeour.com"],["ghmh.com"],
    ["nnm.com"],["knm.com"],[4],["cbtg.com"],["acyvwod.com"],["mydr.com"]]
     */
    public void leetcodeTest(BrowserHistory history) {
        history.visit("bx.com");
        history.visit("bjyfmln.com");
        System.out.println("Back: " + history.back(3));
        history.visit("ijtrqk.com");
        history.visit("dft.com");
        System.out.println("Back: " + history.back(10));
        System.out.println("forward: " + history.forward(10));
        history.visit("yc.com");
        history.visit("yhl.com");
        history.visit("xynxvix.com");
        history.visit("izfscdv.com");
        history.visit("cdenhm.com");
        history.visit("ocgcjz.com");
        System.out.println("forward: " + history.forward(5));
        System.out.println("forward: " + history.forward(5));
        history.visit("gtd.com");
        System.out.println("Back: " + history.back(9));
        history.visit("hfeour.com");
        history.visit("ghmh.com");
        history.visit("nnm.com");
        history.visit("knm.com");
        System.out.println("forward: " + history.forward(4));
        history.visit("cbtg.com");
        history.visit("acyvwod.com");
        history.visit("mydr.com");
        System.out.println("Most Recent: " + history.lastVisited());
    }

    public void visit(String url) {
        if (index < history.size() - 1) {
            int i = 0;
            Iterator<String> ite = history.iterator();
            while (ite.hasNext()) {
                ite.next();
                if (i >= index) {
                    ite.remove();
                }
                i++;
            }
        }
        history.add(url);
        index = history.size() - 1;
        System.out.println("History: " + history + " Index: " + index);
    }

    public String back() {
        String prev = "";
        if (index >= 1 && index < history.size()) {
            prev = history.get(--index);
        } else {
            prev = history.get(0);
        }
        System.out.println("History: " + history + " Index: " + index);
        return prev;
    }

    public String back(int steps) {
        int lookup = index - steps;
        if (lookup >= 0 && lookup < history.size()) {
            index = lookup;
        } else {
            index = 0;
        }
        System.out.println("History: " + history + " Index: " + index);
        return history.get(index);
    }

    public String forward() {
        String next = "";
        int size = history.size();
        if (index >= 0 && index < size - 2) {
            next = history.get(++index);
        } else {
            next = history.get(size - 1);
        }
        System.out.println("History: " + history + " Index: " + index);
        return next;
    }

    public String forward(int steps) {
        int size = history.size();
        int lookup = index + steps;
        if (lookup >= 0 && lookup < size) {
            index = lookup;
        } else {
            index = size - 1;
        }
        System.out.println("History: " + history + " Index: " + index);
        return history.get(index);
    }

    public String lastVisited() {
        System.out.println("History: " + history + " Index: " + index);
        return history.get(index);
    }
}