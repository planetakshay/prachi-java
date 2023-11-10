package practice2023.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NArryTreeHeight {

    public int computeHeight(NArryTreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.children == null || root.children.isEmpty()) {
            return 0;
        }
        int height = 0;
        for(NArryTreeNode child : root.children) {
            int childHeight = computeHeight(child) + 1;
            height = Math.max(height, childHeight);
        }
        return height;
    }
    public int computeHeightBFS(NArryTreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<NArryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                NArryTreeNode node = queue.poll();
                if(node.children != null && !node.children.isEmpty()) {
                    for(NArryTreeNode child : node.children) {
                        queue.add(child);
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }
}

class NArryTreeNode {
    int value;
    List<NArryTreeNode> children;
}
