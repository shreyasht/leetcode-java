package com.leet.code;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return isSum(root, sum);
	}

	/*
	 *Remember: It is better to reduce the node value from the sum to see if the sum reaches 0!
	 */

	boolean isSum(TreeNode node, int sum) {
		if (node == null) {
			return false;
		}
		if ((node.left == null && node.right == null) && sum == node.val) {
			return true;
		}
		return
				isSum(node.left, sum - node.val)
						|| isSum(node.right, sum - node.val);
	}


	public static void main(String[] args) {
		PathSum pathSum = new PathSum();

		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(4);
		tree.left.left = new TreeNode(11);
		tree.left.left.left = new TreeNode(7);
		tree.left.left.right = new TreeNode(2);

		tree.right = new TreeNode(8);
		tree.right.left = new TreeNode(13);
		tree.right.right = new TreeNode(4);
		tree.right.right.right = new TreeNode(1);

		System.out.println(pathSum.hasPathSum(tree, 22));

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		System.out.println(pathSum.hasPathSum(tree2, 1));
	}

}
