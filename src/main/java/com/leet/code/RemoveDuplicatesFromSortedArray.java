package com.leet.code;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-array/ */

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		Map<Integer, Integer> positionMap = new LinkedHashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!positionMap.containsKey(nums[i])) {
				positionMap.put(nums[i], i);
			}
		}
		int j =0;
		for (int num : positionMap.keySet()) {
			nums[j] = num;
			j++;
		}

		return positionMap.size();
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2};
		RemoveDuplicatesFromSortedArray fromSortedArray = new RemoveDuplicatesFromSortedArray();
		int res =fromSortedArray.removeDuplicates(arr);
		System.out.println("Result is "+ res + " Array is "+ Arrays.toString(arr));
	}
}
