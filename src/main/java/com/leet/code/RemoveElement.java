package com.leet.code;

/* https://leetcode.com/problems/remove-element/ */

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}


	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
		RemoveElement fromSortedArray = new RemoveElement();
		int res = fromSortedArray.removeElement(arr, 2);
		System.out.println("Result is " + res + " Array is " + Arrays.toString(arr));
	}

}
