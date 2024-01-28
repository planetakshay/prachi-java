package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * <p>
 * Asked in JPMorgan Chase phone screen
 * Apple onsite.
 * <p>
 * Covered in Graph problem sets in IK
 * <p>
 * This algorithm is to produce a topological order using topological
 * sorting on a DAG (directed acyclic graphs)
 * <p>
 * Interview Kickstart
 */
public class CourseSchedule2 {

    static ArrayList<Integer> course_schedule(Integer n, ArrayList<ArrayList<Integer>> prerequisites) {

        ArrayList<Integer> orderedCourses = new ArrayList<>();
        if (prerequisites == null || prerequisites.size() == 0) {
            for (int i = 0; i < n; i++) {
                orderedCourses.add(i);
            }
            return orderedCourses;
        }
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int totalPrereq = prerequisites.size();
        for (int i = 0; i < totalPrereq; i++) {
            List<Integer> pair = prerequisites.get(i);
            System.out.println(pair);
            int course = pair.get(0);
            int prereq = pair.get(1);
            indegree[course]++;
            List<Integer> neighbours = adjMap.getOrDefault(prereq, new ArrayList<>());
            neighbours.add(course);
            adjMap.put(prereq, neighbours);
        }

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                bfs.offer(i);
            }
        }

        int index = 0;
        while (!bfs.isEmpty()) {
            int course = bfs.poll();
            orderedCourses.add(index++, course);
            if (adjMap.containsKey(course)) {
                List<Integer> neighbours = adjMap.get(course);
                for (int neighbour : neighbours) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        bfs.offer(neighbour);
                    }
                }
            }
        }
        return index == n ? orderedCourses : new ArrayList<>(List.of(-1));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        // Build indegrees and adjacencyList.
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            inDegree[dest]++;

            List<Integer> list = adjacencyMap.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjacencyMap.put(src, list);
        }

        // Push all the vertices in the queue that are
        // having zero inDegree.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] orderedCourses = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            orderedCourses[index++] = node;
            //Reduce the indegree of each neighbour of node
            if (adjacencyMap.containsKey(node)) {
                for (Integer neighbour : adjacencyMap.get(node)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        // If index is same as numCourses means there is no cycle.
        if (index == numCourses) {
            return orderedCourses;
        }
        // cycle detected.
        return new int[0];
    }
}
