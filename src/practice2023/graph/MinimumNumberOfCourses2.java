package practice2023.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/parallel-courses-ii/
 *
 *
 */
public class MinimumNumberOfCourses2 {
    public static void main(String[] args) {
        int[][] prereq = new int[][]{{2, 1},{3, 1}, {1, 4}};
        int noOfCourse = 4;
        int maxPerSem = 2;
        System.out.println("Minimum Semesters required \nto take all courses: " + minimumSemesters(noOfCourse, prereq, maxPerSem));

        prereq = new int[][]{{2, 1},{3, 1}, {4,1}, {1, 5}};
        noOfCourse = 5;
        maxPerSem = 2;
        System.out.println("Minimum Semesters required \nto take all courses: " + minimumSemesters(noOfCourse, prereq, maxPerSem));
    }

    /**
     * Topological sorting for DAG (Directed Acyclic Graphs).
     * @param n
     * @param relations
     * @return
     */
    public static int minimumSemesters(int n, int[][] relations, int k) {
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
}
