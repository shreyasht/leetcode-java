package com.leet.code;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		helper(root);
	}

	private TreeNode helper(TreeNode root) {
		if(root == null) {
			return null;
		}
		//Get tail for the left node and also flatten left substree
		TreeNode leftTail = helper(root.left);
		//Get tail for the right substree and also flatten right substree
		TreeNode rightTail = helper(root.right);
		//Save reference
		TreeNode left = root.left;
		TreeNode right = root.right;
		//If left node is not empty and left tail is not null, means i need to flatten the root.
		if (left != null && leftTail != null) {
			root.right = left;
			leftTail.right = right;
			root.left = null;
		}
		//if i do not have any children, i am the tail.
		if (leftTail == null && rightTail == null) {
			return root;
		}
		//if right tail is null, then I need to return left tail.
		if (rightTail == null) {
			return leftTail;
		}
		return rightTail;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
		flattenBinaryTreeToLinkedList.flatten(tree);
	}
}
