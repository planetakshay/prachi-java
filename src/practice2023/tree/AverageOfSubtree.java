package practice2023.tree;

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */
public class AverageOfSubtree {
    int totalNodes = 0;
    public int averageOfSubtree(TreeNode root) {
        findNodesInSubtree(root);
        return totalNodes;
    }

    public NodeAverage findNodesInSubtree(TreeNode root) {
        if(root == null) {
            return new NodeAverage(0, 0);
        }
        NodeAverage left = findNodesInSubtree(root.left);
        NodeAverage right = findNodesInSubtree(root.right);
        int total = left.sum + right.sum + root.val;
        int count = left.size + right.size + 1;

        if(root.val == (total / count)) {
            totalNodes++;
        }
        return new NodeAverage(count, total);
    }
}

class NodeAverage {
    int size;
    int sum;

    public NodeAverage(int size, int sum) {
        this.size = size;
        this.sum = sum;
    }
}