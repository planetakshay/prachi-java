package algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Atlassian Phone Screen:
 * <p>
 * Interviewer: Chetan Ithal
 * <p>
 * Given a collection Ballots containing three candidates in the order
 * of preference. return first 3 winners.
 */
public class Ballot {
    String pref1;
    String pref2;
    String pref3;

    public Ballot(String pref1, String pref2, String pref3) {
        this.pref1 = pref1;
        this.pref2 = pref2;
        this.pref3 = pref3;
    }

    public static void main(String[] args) {
        Ballot b1 = new Ballot("A", "B", "C");
        Ballot b2 = new Ballot("B", "C", "D");
        Ballot b3 = new Ballot("E", "C", null);

        Ballot b4 = new Ballot("E", "A", null);
        Ballot b5 = new Ballot("E", null, "A");

        List<String> winners = b1.getResults(Arrays.asList(b1, b2, b3, b4, b5));
        winners.forEach(System.out::println);
    }

    public static void populateMap(String candidate, Integer weight, Map<String, Integer> candidateVotes) {
        String pref = Candidate.getName(candidate);
        if (pref != null) {
            candidateVotes.put(pref, candidateVotes.getOrDefault(pref, 0) + weight);
        }
    }

    public List<String> getResults(List<Ballot> ballots) {
        // value of pref1 = 3, pref2= 2 and pref1= 1;
        Map<String, Integer> candidateVotes = new TreeMap<>();
        for (Ballot ballot : ballots) {
            populateMap(ballot.pref1, 3, candidateVotes);
            populateMap(ballot.pref2, 2, candidateVotes);
            populateMap(ballot.pref3, 1, candidateVotes);
        }
        List<Map.Entry<String, Integer>> winners = candidateVotes.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
        return winners.stream().limit(3).map(e -> e.getKey()).collect(Collectors.toList());
    }

    enum Candidate {
        A("A"), B("B"), C("C"), D("D"), E("E"), F("F");
        String name;

        Candidate(String name) {
            this.name = name;
        }

        public static String getName(String name) {
            for (Candidate candidate : Candidate.values()) {
                if (candidate.getName().equalsIgnoreCase(name)) {
                    return name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
    }
}