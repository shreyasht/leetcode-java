package com.leet.code;

public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		return tree(0, nums.length-1, nums);
	}

	TreeNode tree(int l, int h, int[] nums) {
		if (l > h) {
			return null;
		}
		int m = l + (h - l) / 2;
		TreeNode treeNode = new TreeNode(nums[m]);
		treeNode.left = tree(l, m - 1, nums);
		treeNode.right = tree(m + 1, h, nums);
		return treeNode;
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree =
				new ConvertSortedArrayToBinarySearchTree();
		int[] arr = {-10, -3, 0, 5, 9};
		System.out.println(convertSortedArrayToBinarySearchTree.sortedArrayToBST(arr).toString());
	}
}

