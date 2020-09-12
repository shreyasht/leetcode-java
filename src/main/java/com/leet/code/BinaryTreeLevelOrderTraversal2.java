package com.leet.code;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> intList = new ArrayList<>();
		int height = height(root);


		for (int i = height; i >= 1; i--) {
			List<Integer> integerList = new ArrayList<>();
			traverseBFS(root, i, integerList);
			intList.add(integerList);
		}

		return intList;
	}

	void traverseBFS(TreeNode treeNode, int level, List<Integer> intList) {
		if (treeNode == null) {
			return;
		}
		if (level == 1) {
			intList.add(treeNode.val);
		} else if (level > 1) {
			traverseBFS(treeNode.left, level - 1, intList);
			traverseBFS(treeNode.right, level - 1, intList);
		}
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

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(3);
		BinaryTreeLevelOrderTraversal2 binaryTreeLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
		System.out.println(binaryTreeLevelOrderTraversal2.levelOrderBottom(tree));
	}
}
