package com.leet.code;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(5);
		tree.left.left= new TreeNode(6);
		tree.left.right= new TreeNode(2);
		tree.left.right.left= new TreeNode(7);
		tree.left.right.right= new TreeNode(4);
		tree.right = new TreeNode(1);
		tree.right.left = new TreeNode(0);
		tree.right.right = new TreeNode(8);


		System.out.println(LowestCommonAncestor.lowestCommonAncestor(tree,tree.left,tree.left.right.right));

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		//base case
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		//result
		if(left == null) {
			return right;
		}
		else if(right == null) {
			return left;
		}
		else { //both left and right are not null, we found our result
			return root;
		}
	}
}
