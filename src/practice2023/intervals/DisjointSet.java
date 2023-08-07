package practice2023.intervals;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-people-with-secret/description/
 * <p>
 * Learnt how to solve using Union and Find and Path Compression
 * for Minimal Spanning Tree.
 * https://walkccc.me/LeetCode/problems/2092/
 */
public class DisjointSet {
    public static final Integer TOTAL_NODES = 50;

    private int[] parent;
    private int[] rank;

    public static void main(String[] args) {
        DisjointSet sets = new DisjointSet();

        int[][] meetings = new int[][]{{1, 2, 100}, {3, 4, 200}, {1, 3, 300}, {2, 5, 400}};
        List<Integer> aware = sets.findAllPeople(6, meetings, 1);
        System.out.println("People aware of the story: " + Arrays.toString(aware.toArray()));

        meetings = new int[][]{{1, 2, 100}, {2, 3, 100}, {4, 5, 100}};
        aware = sets.findAllPeople(6, meetings, 2);
        System.out.println("People aware of the story: " + Arrays.toString(aware.toArray()));
    }

    public void init(int n) {
        if (n <= 0) {
            n = TOTAL_NODES;
        }
        parent = new int[n];
        rank = new int[n]; // All ranks will have initial value 0

        int parentLen = parent.length;
        for (int i = 1; i < parentLen; i++) {
            parent[i] = i;
            // rank[i] = 0; this is taken care of at line 35.
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        } else {
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
    }

    public void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void reset(int u) {
        parent[u] = u;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Initialize parent and rank and find parent and rank for the first person.
        init(n);
        union(0, firstPerson);

        // Timestamp as a key and meeting between two people is a value.
        TreeMap<Integer, List<StorySharing>> learntStory = new TreeMap<>();
        for (int[] meeting : meetings) {
            learntStory.putIfAbsent(meeting[2], new ArrayList<>());
            learntStory.get(meeting[2]).add(new StorySharing(meeting[0], meeting[1]));
        }

        for (List<StorySharing> stories : learntStory.values()) {
            Set<Integer> people = new HashSet<>();
            for (StorySharing story : stories) {
                final int x = story.getPerson1();
                final int y = story.getPerson2();

                union(x, y);
                people.add(x);
                people.add(y);
            }
            for (int person : people) {
                if (!isConnected(person, 0)) {
                    reset(person);
                }
            }
        }
        List<Integer> aware = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (isConnected(i, 0)) {
                aware.add(i);
            }
        }
        return aware;
    }
}

class StorySharing {
    int person1;
    int person2;
    int timestamp;

    public StorySharing(int person1, int person2, int timestamp) {
        this.person1 = person1;
        this.person2 = person2;
        this.timestamp = timestamp;
    }

    public StorySharing(int person1, int person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public StorySharing(String story) {
        String withoutParens = story.substring(1, story.length() - 2);
        String[] details = withoutParens.split(",");

        if (details != null && details.length == 3) {
            this.person1 = Integer.parseInt(details[0].trim());
            this.person2 = Integer.parseInt(details[1].trim());
            this.timestamp = Integer.parseInt(details[2].trim());
        }
    }

    public int getPerson1() {
        return person1;
    }

    public void setPerson1(int person1) {
        this.person1 = person1;
    }

    public int getPerson2() {
        return person2;
    }

    public void setPerson2(int person2) {
        this.person2 = person2;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorySharing story)) return false;
        return person1 == story.person1 && person2 == story.person2 && timestamp == story.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person1, person2, timestamp);
    }
}