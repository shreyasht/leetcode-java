package com.leet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* https://leetcode.com/problems/same-tree/
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		List<Integer> nodeList1 = new ArrayList<>();
		List<Integer> nodeList2 = new ArrayList<>();
		preorder(p, nodeList1);
		preorder(q, nodeList2);
		if (nodeList1.size() != nodeList2.size()) {
			return false;
		}

		for (int i = 0; i < nodeList1.size(); i++) {
			if (!Objects.equals(nodeList1.get(i), nodeList2.get(i))) {
				return false;
			}
		}

		return true;

	}

	void preorder(TreeNode treeNode, List<Integer> nodeList) {

		if (treeNode == null) {
			nodeList.add(null);
			return;
		}
		nodeList.add(treeNode.val);

		preorder(treeNode.left, nodeList);

		preorder(treeNode.right, nodeList);
	}

	TreeNode ans;
	public void getTarget(TreeNode node, int target){
		if(node==null){
			return;
		}

		if(node.val==target){
			ans = node;
			return;
		}

		getTarget(node.left,target);
		getTarget(node.right,target);
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);
		tree2.left.left = new TreeNode(4);
		tree2.left.right = new TreeNode(5);

		SameTree sameTree = new SameTree();
		System.out.println(sameTree.isSameTree(tree, tree2));

		sameTree.getTarget(tree,4);
		System.out.println(sameTree.ans);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
