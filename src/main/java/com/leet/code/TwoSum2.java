package com.leet.code;

import java.util.Arrays;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		while (numbers[left] + numbers[right] != target) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
			if (left == right) {
				return new int[]{};
			}
		}
		return new int[]{left + 1, right + 1};
	}

	public static void main(String[] args) {
		TwoSum2 twoSum2 = new TwoSum2();
		int[] arr = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum2.twoSum(arr, 9)));
	}
}
