package com.leet.code;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		} else {
			return height(root);
		}
	}

	int height(TreeNode treeNode) {
		if (treeNode == null) {
			// max value for comparison. case [1,2]
			return Integer.MAX_VALUE;
		}
		if (treeNode.left == null && treeNode.right == null) {
			return 1;
		}
		int leftHeight = height(treeNode.left);
		int rightHeight = height(treeNode.right);

		if (leftHeight < rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		//tree.right = new TreeNode(20);
		///tree.right.left = new TreeNode(15);
		//tree.right.right = new TreeNode(7);

		System.out.println(minimumDepthOfBinaryTree.minDepth(tree));
	}
}
