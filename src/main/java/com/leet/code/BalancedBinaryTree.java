package com.leet.code;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}

	int height(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		int leftHeight = height(treeNode.left);
		int rightHeight = height(treeNode.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;

	}

	public static void main(String[] args) {
		BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);

		System.out.println(balancedBinaryTree.isBalanced(tree));

	}

}
