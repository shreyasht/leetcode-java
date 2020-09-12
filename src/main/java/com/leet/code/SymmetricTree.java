package com.leet.code;

/* https://leetcode.com/problems/symmetric-tree/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		int height = height(root);
		System.out.println(height);

		for (int i = 1; i <= height; i++) {
			levelOrder(root, i);
		}

		return checkSymmetry(root, root);
	}

	int height(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		int leftHeight = height(treeNode.left);
		int rightHeight = height(treeNode.right);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	void levelOrder(TreeNode treeNode, int level) {
		if (treeNode == null) {
			return;
		}

		if (level == 1) {
			System.out.print(treeNode.val + " ");
		} else if (level > 1) {
			levelOrder(treeNode.left, level - 1);

			levelOrder(treeNode.right, level - 1);
		}
	}

	boolean checkSymmetry(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		return ((t1.val == t2.val) && checkSymmetry(t1.left, t2.right) && checkSymmetry(t1.right, t2.left));
	}


	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(3);

		SymmetricTree symmetricTree = new SymmetricTree();
		System.out.println(symmetricTree.isSymmetric(tree));
	}
}
