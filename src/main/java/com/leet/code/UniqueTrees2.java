package com.leet.code;

import java.util.LinkedList;
import java.util.List;

public class UniqueTrees2 {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new LinkedList<>();
		}

		return generate(1, n);
	}

	private List<TreeNode> generate(int left, int right) {
		List<TreeNode> result = new LinkedList<>();

		if (left > right) {
			result.add(null);
		} else {
			for (int i = left; i <= right; i++) {
				// generate subtrees on left making root = i
				List<TreeNode> leftTrees = generate(left, i - 1);

				// generate subtrees on right making root = i
				List<TreeNode> rightTrees = generate(i + 1, right);

				for (TreeNode leftTree : leftTrees) {
					for (TreeNode rightTree : rightTrees) {
						TreeNode root = new TreeNode(i);
						root.left = leftTree;
						root.right = rightTree;
						result.add(root);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		UniqueTrees2 uniqueTrees2 = new UniqueTrees2();
		List<TreeNode> result = uniqueTrees2.generateTrees(2);
		for(TreeNode node: result){
			System.out.println(node);
		}
	}
}
