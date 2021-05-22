package com.leet.code;

import java.util.HashMap;
import java.util.Map;

public class InorderPostorderTree {

	public static void main(String[] args) {
		InorderPostorderTree tree = new
				InorderPostorderTree();
		int [] inorder ={9,3,15,20,7};
		int [] postorder ={9,15,7,20,3};

		System.out.println(tree.buildTree(inorder,postorder));
	}

	Map<Integer,Integer> inOrderMap;
	int index;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		inOrderMap = new HashMap<>();
		for(int i=0;i<inorder.length;i++){
			inOrderMap.put(inorder[i],i);
		}

		index = inorder.length-1;

		return build(postorder,0,postorder.length-1);
	}

	TreeNode build(int[] postorder, int startIndex, int endIndex){
		if(startIndex>endIndex){
			return null;
		} else {
			int postOrderElem = postorder[index];
			int i=inOrderMap.get(postOrderElem);
			TreeNode node = new TreeNode(postOrderElem);
			index--;

			node.right=build(postorder,i+1,endIndex);
			node.left=build(postorder,startIndex,i-1);
			return node;
		}
	}
}
