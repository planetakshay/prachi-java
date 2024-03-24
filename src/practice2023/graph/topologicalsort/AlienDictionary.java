package practice2023.graph.topologicalsort;

import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {
    Map<Character, List<Character>> adjMap;
    Map<Character, Integer> arrival;
    Map<Character, Integer> departure;
    int timestamp;

    StringBuilder alienAlphabets = new StringBuilder();
    public static void main(String[] args) {
        String[] alienWords = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Alien Dictionary Alphabets: " + alienOrder(alienWords));

        alienWords = new String[]{"z", "x"};
        System.out.println("Alien Dictionary Alphabets: " + alienOrder(alienWords));

        alienWords = new String[]{"z", "x", "z"};
        System.out.println("Alien Dictionary Alphabets: " + alienOrder(alienWords));

        AlienDictionary dictionary = new AlienDictionary();
        alienWords = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Alien Dictionary Alphabets: " + dictionary.alienOrderDFS(Arrays.asList(alienWords)));

        dictionary = new AlienDictionary();
        alienWords = new String[]{"z", "x"};
        System.out.println("Alien Dictionary Alphabets: " + dictionary.alienOrderDFS(Arrays.asList(alienWords)));

        dictionary = new AlienDictionary();
        alienWords = new String[]{"z", "x", "z"};
        System.out.println("Alien Dictionary Alphabets: " + dictionary.alienOrderDFS(Arrays.asList(alienWords)));
    }

    /**
     * Following solution uses BFS traversal and performs
     * Topological Sorting and arranges characters in alien
     * language in topological order (in this case lexicographically sorted order).
     * @param words
     * @return
     */
    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        // Initialize collections.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Establish links
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            // This means that the input is invalid as next word
            // should be lexicographically greater than the curr.

            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            int smaller = Math.min(curr.length(), next.length());
            for (int j = 0; j < smaller; j++) {
                if (curr.charAt(j) != next.charAt(j)) {

                    // This condition indicates at jth index,
                    // char in curr comes before char in next
                    // and that establishes and edge between
                    // two characters.

                    adjList.get(curr.charAt(j)).add(next.charAt(j));
                    // Now char in next at jth index has an
                    // inDegree as we established an edge
                    // between two vertices.

                    inDegree.put(next.charAt(j), inDegree.get(next.charAt(j)) + 1);
                    break;
                }
            }
        }

        // Topological Sorting
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // Add all vertices having zero indegrees to the queue
        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            builder.append(node);
            for (Character next : adjList.get(node)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next).equals(0)) {
                    queue.offer(next);
                }
            }
        }
        if (builder.length() < inDegree.size()) {
            return "";
        }
        return builder.toString();
    }

    /**
     * Method signature and implementation is from IK timed test.
     * Uses DFS traversal.
     *
     * Interview Kickstart.
     * @param words
     * @return
     */
    public String alienOrderDFS(List<String> words) {
        adjMap = new HashMap<>();
        arrival = new HashMap<>();
        departure = new HashMap<>();
        timestamp = 0;

        for(String word : words) {
            for(int i=0; i < word.length(); i++) {
                char curr = word.charAt(i);
                adjMap.put(curr, new ArrayList<>());
                arrival.put(curr, -1);
                departure.put(curr, -1);
            }
        }

        for(int i=0; i < words.size() - 1; i++) {
            String curr = words.get(i);
            String next = words.get(i + 1);
            int currLen = curr.length();
            int nextLen = next.length();
            if (currLen > nextLen && curr.startsWith(next)) {
                return "";
            }
            int smallest = Math.min(currLen, nextLen);
            for (int j = 0; j < smallest; j++) {
                char currCh = curr.charAt(j);
                char nextCh = next.charAt(j);
                if (currCh != nextCh) {
                    adjMap.get(currCh).add(nextCh);
                    break;
                }
            }
        }

        for(char ch : adjMap.keySet()) {
            if(arrival.get(ch) == -1) {
                dfs(ch);
            }
        }
        return alienAlphabets.reverse().toString();
    }

    private void dfs(char src) {
        arrival.put(src, timestamp++);
        for(char nei : adjMap.get(src)) {
            if(arrival.get(nei) == -1) {
                dfs(nei);
            }
        }
        departure.put(src, timestamp++);
        alienAlphabets.append(src);
    }
}
