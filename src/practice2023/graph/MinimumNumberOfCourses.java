package practice2023.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/parallel-courses/description/
 * https://leetcode.com/problems/course-schedule/description/
 *
 */
public class MinimumNumberOfCourses {
    public static void main(String[] args) {
        int[][] prereq = new int[][]{{1,3},{2,3}};
        int noOfCourse = 3;
        System.out.println("Minimum Semesters required \nto take all courses: " + minimumSemesters(noOfCourse, prereq));

        prereq = new int[][]{{1,2},{2,3}, {3,1}};
        noOfCourse = 3;
        System.out.println("Minimum Semesters required \nto take all courses: " + minimumSemesters(noOfCourse, prereq));
    }

    /**
     * Topological sorting for DAG (Directed Acyclic Graphs).
     * @param n
     * @param relations
     * @return
     */
    public static int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        // Initialize graph
        for(int i = 0; i < n + 1;i++) {
            graph.add(new ArrayList<>());
        }
        // Initialize inDegree for vertices using the relations array
        for(int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }
        // Add all the vertices with indegree 0 to the bfs list.
        List<Integer> bfs = new ArrayList<>();
        // We will ignore element at the 0th index.
        for(int i=1;i < n+1; i++) {
            if(inDegree[i] == 0) {
                bfs.add(i);
            }
        }
        int noOfSemesters = 0;
        int courseCount = 0;
        // Calculate how many courses are finished.
        while(!bfs.isEmpty()) {
            noOfSemesters++;
            List<Integer> nextCourse = new ArrayList<>();
            for(int course : bfs) {
                courseCount++;
                for(int end : graph.get(course)) {
                    inDegree[end]--;
                    // If all prereqs are learned
                    if(inDegree[end] == 0) {
                        nextCourse.add(end);
                    }
                }
            }
            bfs = nextCourse;
        }
        return courseCount == n ? noOfSemesters : -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}
