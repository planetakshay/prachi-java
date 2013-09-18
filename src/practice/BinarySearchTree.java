package practice;

import java.util.LinkedList;
import java.util.Queue;

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

	}

	public void inOrderTraversal(TreeStructure root) {

		if (root == null) {

			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.data + "\t");
		inOrderTraversal(root.right);
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

	// Without recursion
	/**
	 * HP on-site. This is also called Breadth first search algorithm
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

	boolean isBalanced(TreeStructure node) {

		if (maxDepth(node) - minDepth(node) > 1) {

			return false;
		}
		return true;
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