package practice2023.sorting;

import java.util.*;

public class RankTeamsByVotes {
    public static void main(String[] args) {
        String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        System.out.println("Rank: " + rankTeams(votes));
    }

    public static String rankTeams(String[] votes) {
        Candidate[] candidates = new Candidate[26];
        int size = votes[0].length();
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = new Candidate((char) ('A' + i), size);
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                ++candidates[vote.charAt(i) - 'A'].votes[i];
            }
        }
        Arrays.sort(candidates, new Comparator<Candidate>() {
            public int compare(Candidate a, Candidate b) {
                for (int i = 0; i < a.votes.length; i++) {
                    if (a.votes[i] > b.votes[i]) {
                        return -1;
                    } else if (a.votes[i] < b.votes[i]) {
                        return 1;
                    }
                }
                return a.getName() - b.getName();
            }
        });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(candidates[i].getName());

        }
        return builder.toString();
    }
}

class Candidate {
    char name;
    int[] votes;

    public Candidate() {
    }

    public Candidate(char name, int size) {
        this.name = name;
        this.votes = new int[size];
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int[] getVotes() {
        return votes;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }
}