package practice2023.design;

import practice2023.tree.MaxSumBstInBt;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Included in Blind 75 problems.
 * Apple Ads team onsite.
 *
 * BST is throwing TLE in leetcode.
 */
public class MedianFinderBinarySearchTree {
    int noOfNodes;
    BinarySearchTree curr, root;
    public MedianFinderBinarySearchTree() {

    }
    public void addNum(int num) {
        if(root == null) {
            root = new BinarySearchTree(num, null);
            curr = root;
            noOfNodes = 1;
        } else {
            root.add(num);
            noOfNodes++;
            if(noOfNodes % 2 == 1) {
                if(curr.val <= num) {
                    curr = curr.next();
                }
            } else {
                if(curr.val > num) {
                    curr = curr.prev();
                }
            }
        }
    }
    public double findMedian() {
        if(noOfNodes % 2 == 0) {
            return ((double) curr.next().val + curr.val) / 2;
        } else {
            return curr.val;
        }
    }
}

class BinarySearchTree {
    int val;
    BinarySearchTree left;
    BinarySearchTree right;
    BinarySearchTree parent;

    public BinarySearchTree(int val, BinarySearchTree parent) {
        this.val = val;
        this.parent = parent;
    }

    public void add(int num) {
        if(num >= val) {
            if(right == null) {
                right = new BinarySearchTree(num, this);
            } else {
                right.add(num);
            }
        } else {
            if(left == null) {
                left = new BinarySearchTree(num, this);
            } else {
                left.add(num);
            }
        }
    }

    public BinarySearchTree next() {
        BinarySearchTree curr;
        if(right != null) {
            curr = right;
            while(curr.left != null) {
                curr = curr.left;
            }
        } else {
            curr = this;
            while(curr.parent.right == curr) {
                curr = curr.parent;
            }
            curr = curr.parent;
        }
        return curr;
    }

    public BinarySearchTree prev() {
        BinarySearchTree curr;
        if(left != null) {
            curr = left;
            while(curr.right != null) {
                curr = curr.right;
            }
        } else {
            curr = this;
            while(curr.parent.left == curr) {
                curr = curr.parent;
            }
            curr = curr.parent;
        }
        return curr;
    }
}