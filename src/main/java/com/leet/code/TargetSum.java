package com.leet.code;

public class TargetSum {

	static int count = 0;

	public static int findTargetSumWays(int[] nums, int target) {
		calculate(nums, 0, 0, target);
		return count;
	}


	public static void calculate(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S)
				count++;
		} else {
			calculate(nums, i + 1, sum + nums[i], S);
			calculate(nums, i + 1, sum - nums[i], S);
		}
	}

	public static void main(String[] args) {
		int [] arr = {1,1};
		System.out.println(findTargetSumWays(arr,2));
	}
}
