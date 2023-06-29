package practice;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeStructure node = null;
		node = bst.insert(node, 10);
		node = bst.insert(node, 9);
		node = bst.insert(node, 7);
		node = bst.insert(node, 5);
		node = bst.insert(node, 30);
		node = bst.insert(node, 25);
		node = bst.insert(node, 20);
		node = bst.insert(node, 15);
		node = bst.insert(node, 4);
		node = bst.insert(node, 8);
		node = bst.insert(node, 40);
		node = bst.insert(node, 1);
		node = bst.insert(node, 6);

		bst.printTreeLayers(node);
		// bst.inOrderTraversal(node);
		System.out.println("\nDepth: " + bst.maxDepth(node));
		System.out.println("Lowest Common Ancestor: "
				+ bst.findLowestCommonAncestor(node, 40, 15).data);
		System.out.println(bst.treeDiameter(node));
		System.out.println(bst.size(node));

		nonRecursiveInOrderTraversal(node);
	}

	public static void nonRecursiveInOrderTraversal(TreeStructure root) {
		if(root != null) {
			System.out.println("In order traversal iterative solution.");
			Stack<TreeStructure> stack = new Stack<>();
			TreeStructure curr = root;
			while(curr != null || !stack.isEmpty()) {
				while(curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
				// VERY IMPORTANT
				// curr will be null at the end of inner while loop.
				// So preserve reference of the last node pushed
				// to stack before printing the value of the popped node.
				curr = stack.pop();
				System.out.print(curr.data + "\t");
				curr = curr.right;
			}
		}
	}

	public void inOrderTraversal(TreeStructure root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + "\t");
		inOrderTraversal(root.right);
	}

	public void preOrderTraversal(TreeStructure root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + "\t");
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
	}

	public void postOrderTraversal(TreeStructure root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
		System.out.print(root.data + "\t");
	}


	public TreeStructure insert(TreeStructure node, int value) {
		if (node == null) {
			node = new TreeStructure();
			node.data = value;
		} else {
			if (node.data > value) {
				node.left = insert(node.left, value);
			} else if (node.data <= value) {
				node.right = insert(node.right, value);
			}
		}
		return node;
	}

	public TreeStructure deleteNode(TreeStructure root, int value) {
		if(root == null) {
			return root;
		}
		if(root.data > value) {
			return deleteNode(root.left,value);
		} else if(root.data < value) {
			return deleteNode(root.right,value);
		}
		if(root.left == null) {
			return root.right;
		} else if(root.right == null) {
			return root.left;
		} else {
			TreeStructure succParent = root;
			// Find successor
			TreeStructure succ = root.right;
			while (succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}
			// Delete successor.  Since successor
			// is always left child of its parent
			// we can safely make successor's right
			// right child as left of its parent.
			// If there is no succ, then assign
			// succ.right to succParent.right
			if (succParent != root) {
				succParent.left = succ.right;
			} else {
				succParent.right = succ.right;
			}
			// Copy Successor Data to root
			root.data = succ.data;
			// Delete Successor and return root
			return root;
		}
	}

	/**
	 *
	 * BFS is a way of traversing a Binary Search Tree.
	 * HP on-site. This is also called Breadth first search (BFS) algorithm
	 *
	 * Use Queue data structure for iterative solution(non-recursive) for BFS
	 * The tree is printed layer by layer.
	 *
	 * @param root
	 */
	public void printTreeLayers(TreeStructure root) {
		Queue<TreeStructure> queue = new LinkedList<TreeStructure>();
		queue.add(root);
		TreeStructure node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data + "\t");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public int maxDepth(TreeStructure node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public int minDepth(TreeStructure node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	boolean isBalanced(TreeStructure node) {
		if (maxDepth(node) - minDepth(node) > 1) {
			return false;
		}
		return true;
	}

	public int heightLeft(TreeStructure node) {
		if (node == null) {
			return 0;
		}
		return 1 + heightLeft(node.left);
	}

	public int heightRight(TreeStructure node) {
		if (node == null) {
			return 0;
		}
		return 1 + heightRight(node.right);
	}

	public int treeDiameter(TreeStructure node) {
		if (node == null) {
			return 0;
		}
		int lHeight = heightLeft(node.left);
		int rHeight = heightRight(node.right);
		int ldiameter = treeDiameter(node.left);
		int rdiameter = treeDiameter(node.right);
		return Math.max(lHeight + rHeight + 1, Math.max(ldiameter, rdiameter));
	}

	public TreeStructure findLowestCommonAncestor(TreeStructure root,
												  int value1, int value2) {
		while (root != null) {
			if (root.data > value1 && root.data > value2) {
				root = root.left;
			} else if (root.data < value1 && root.data < value2) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public int size(TreeStructure root) {
		if (root == null) {
			return 0;
		}
		return size(root.left) + 1 + size(root.right);
	}

	/**
	 * Amazon on-site. Given two binary trees, determine if they are mirror of
	 * each other.
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	boolean areMirrorTrees(TreeStructure a, TreeStructure b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		return a.data == b.data && areMirrorTrees(a.left, b.right)
				&& areMirrorTrees(a.right, b.left);
	}

	public boolean isValid(TreeStructure root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeStructure node, int min, int max) {
		if (node == null)
			return true;
		if (node.data > min && node.data < max
				&& isValidBST(node.left, min, node.data)
				&& isValidBST(node.right, node.data, max))
			return true;
		else
			return false;
	}
}

class TreeStructure {
	int data;
	TreeStructure left;
	TreeStructure right;
}