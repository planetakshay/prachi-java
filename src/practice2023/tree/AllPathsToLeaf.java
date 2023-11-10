package practice2023.tree;

import java.util.ArrayList;

/**
 * Covered in IK problem sets.
 *
 * Interview Kickstart.
 */
public class AllPathsToLeaf {
    ArrayList<ArrayList<Integer>> paths;
    ArrayList<ArrayList<Integer>> allPathsOfBinaryTree(TreeNode root) {
        paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        ArrayList<Integer> path = new ArrayList<>();
        findPaths(root, path);
        return paths;
    }

    void findPaths(TreeNode root, ArrayList<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            // very important to initialize
            // as a new array list before adding it to the results.
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        path.add(root.val);
        if (root.left != null) {
            findPaths(root.left, path);
        }
        if (root.right != null) {
            findPaths(root.right, path);
        }
        path.remove(path.size() - 1);
    }
}