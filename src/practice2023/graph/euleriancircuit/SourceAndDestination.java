package practice2023.graph.euleriancircuit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * IntApp interview.
 *
 * [11:54 AM] Kate Galichenko
 * Using the solution of choice, find the start and the destination
 * airport from the flight routes below. In each combination,
 * the first value is the departure airport and the second one is the
 * arrival airport:
 * MIA - PHX
 * LAX - DAL
 * DAL - JFK
 * CHI - WDC
 * JFK - MIA
 * PHX - CHI
 * <p>
 * "MIA - PHX; LAX - DAL; DAL - JFK; CHI - WDC; JFK - MIA; PHX - CHI"
 */
public class SourceAndDestination {
    Map<String, Integer> indegree;
    Map<String, Integer> outdegree;

    public static void main(String[] args) {
        SourceAndDestination obj = new SourceAndDestination();

        String input = "MIA - PHX; LAX - DAL; DAL - JFK; CHI - WDC; JFK - MIA; PHX - CHI";
        StartFinish pair = obj.findStartAndFinish(input);
        System.out.println("Start from " + pair.getStart() + " Finish at " + pair.getFinish());

        input = "B - C; A - B; D - E; C - D";
        pair = obj.findStartAndFinish(input);

        input = "SFO - JFK";
        pair = obj.findStartAndFinish(input);

        // Invalid input
        input = "SFO";
        pair = obj.findStartAndFinish(input);

        // Loop.
        input = "MIA - PHX; LAX - DAL; DAL - JFK; CHI - WDC; JFK - MIA; PHX - CHI; WDC - LAX";
        pair = obj.findStartAndFinish(input);
    }

    public StartFinish findStartAndFinish(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        prepInput(input);
        Set<String> keys = new HashSet<>();
        keys.addAll(indegree.keySet());
        keys.addAll(outdegree.keySet());

        StartFinish pair = null;
        String src = findSrc(keys);
        String dest = findDest(keys);

        if (src != null && dest != null && src.length() > 0 && dest.length() > 0) {
            pair = new StartFinish(src, dest);
            System.out.println("Start from " + pair.getStart() + " Finish at " + pair.getFinish());
        } else {
            System.out.println("Start and finish cannot be determined from the input.");
        }
        return pair;
    }

    public String findSrc(Set<String> keys) {
        String src = "";
        Set<String> indegreeKeys = indegree.keySet();
        for (String key : keys) {
            if (!indegreeKeys.contains(key)) {
                src = key;
            }
        }
        return src;
    }

    public String findDest(Set<String> keys) {
        String dest = "";
        Set<String> outdegreeKeys = outdegree.keySet();
        for (String key : keys) {
            if (!outdegreeKeys.contains(key)) {
                dest = key;
            }
        }
        return dest;
    }

    public void prepInput(String input) {
        String[] startAndFinish = input.split("; ");
        if (startAndFinish.length == 0) {
            return;
        }
        outdegree = new HashMap<>();
        indegree = new HashMap<>();
        for (String str : startAndFinish) {
            String[] places = str.trim().split(" - ");
            if (places.length == 2) {
                String src = places[0].trim();
                String dest = places[1].trim();
                outdegree.put(src, outdegree.getOrDefault(src, 0) + 1);
                indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
            }
        }
    }
}

class StartFinish {
    String start;
    String finish;

    public StartFinish(String start, String finish) {
        this.start = start;
        this.finish = finish;
    }

    public StartFinish() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
}