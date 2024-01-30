package practice2023.tree;

import java.util.*;

/**
 * Walmart onsite.
 */
public class NextNodeInTree {
    Tree root;
    Map<Integer, Tree> map;

    public static void main(String[] args) {
        NextNodeInTree sol = new NextNodeInTree();
        Tree root = sol.createTree();
        sol.root = root;
        sol.populateMap(root);
        System.out.println("Nodes to the right: " + sol.getNodesToTheRight(2));
        System.out.println("Nodes to the right: " + sol.getNodesToTheRight(5));
    }

    public List<Integer> getNodesToTheRight(int target) {
        Tree node = map.get(target);
        List<Integer> result = new ArrayList<>();
        while(node != null) {
            node = node.next;
            if(node != null) {
                result.add(node.value);
            }
        }
        return result;
    }

    public void populateMap(Tree root) {
        if(root != null) {
            bfs(root);
        }
    }

    public void bfs(Tree node) {
        map = new HashMap<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i < size; i++) {
                Tree curr = queue.poll();
                // The if condition below is very important
                // without which the last node in the current level
                // will have its next node pointing to the first node
                // of the next level.
                if(i < size - 1) {
                    curr.next = queue.peek();
                }
                map.put(curr.value, curr);
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
    }

    public Tree createTree() {
        Tree node1 = new Tree();
        node1.value = 2;

        Tree node2 = new Tree();
        node2.value = 3;

        Tree root = new Tree();
        root.value = 1;
        root.left = node1;
        root.right = node2;

        Tree node4 = new Tree();
        node4.value = 4;
        node1.left = node4;

        Tree node5 = new Tree();
        node5.value = 5;
        node1.right = node5;

        Tree node6 = new Tree();
        node6.value = 6;
        node2.left = node6;

        Tree node7 = new Tree();
        node7.value = 7;
        node2.right = node7;

        return root;
    }
}

class Tree {
    int value;
    Tree left;
    Tree right;
    Tree next;

    public Tree() {

    }
}