package practice2023.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindPath {
    private final int v;
    private final List<Integer> adj[];

    FindPath(int v) {
        this.v = v;
        this.adj = new LinkedList[this.v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public static void main(String[] args) {
        FindPath path = new FindPath(4);
        /*path.addEdge(0, 1);
        path.addEdge(1, 2);
        path.addEdge(1, 3); */
        /* path = new FindPath(10);
        path.addEdge(2,9);
        path.addEdge(7,8);
        path.addEdge(5,9);
        path.addEdge(7,2);
        path.addEdge(1,6);
        path.addEdge(3,0);
        path.addEdge(7,0);
        path.addEdge(8,5);*/
        /* path = new FindPath(10);
        path.addEdge(2,9);
        path.addEdge(7,8);
        path.addEdge(5,9);
        path.addEdge(7,2);
        path.addEdge(3,8);
        path.addEdge(2,8);
        path.addEdge(1,6);
        path.addEdge(3,0);
        path.addEdge(7,0);
        path.addEdge(8,5);
                System.out.println("Path exists: " + path.isReachable(1, 0));
*/

        path = new FindPath(10);
        path.addEdge(0,7);
        path.addEdge(0,8);
        path.addEdge(6,1);
        path.addEdge(2,0);
        path.addEdge(0,4);
        path.addEdge(5,8);
        path.addEdge(4,7);
        path.addEdge(1,3);
        path.addEdge(3,5);
        path.addEdge(6,5);
        path.addEdge(8,5);

        System.out.println("Path exists: " + path.isReachable(7, 5));
        //System.out.println("Path exists: " + path.isReachable(0, 3));

    }

    // This is a directed graph. so an edge from u to v doesn't mean
    // There is an edge from v to u.
    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    boolean isReachable(int u, int v) {
        boolean[] visited = new boolean[this.v];
        visited[u] = true;
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(u);

        Iterator<Integer> i = null;
        while (bfsQueue.size() != 0) {
            u = bfsQueue.poll();
            int n;
            i = adj[u].listIterator();
            while (i.hasNext()) {
                n = i.next();
                if (n == v) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    bfsQueue.add(n);
                }
            }
        }
        return false;
    }
}