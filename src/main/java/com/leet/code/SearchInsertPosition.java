package com.leet.code;

/* https://leetcode.com/problems/search-insert-position/ */

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int j = 0;
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target > nums[i]) {
				j++;
			} else {
				return i;
			}
			k++;
		}
		if (j == k) {
			return k;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6};
		SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
		System.out.println("position is: " + searchInsertPosition.searchInsert(arr, 5));
		System.out.println("position is: " + searchInsertPosition.searchInsert(arr, 2));
		System.out.println("position is: " + searchInsertPosition.searchInsert(arr, 7));
		System.out.println("position is: " + searchInsertPosition.searchInsert(arr, 0));
	}

}
